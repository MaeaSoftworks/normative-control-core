package ru.maeasoftworks.normativecontrol.api.students.services

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import ru.maeasoftworks.normativecontrol.api.shared.extensions.uploadDocumentConclusion
import ru.maeasoftworks.normativecontrol.api.shared.extensions.uploadDocumentRender
import ru.maeasoftworks.normativecontrol.api.shared.modules.FileStorage
import ru.maeasoftworks.normativecontrol.api.shared.utils.Rat
import ru.maeasoftworks.normativecontrol.api.shared.utils.with
import ru.maeasoftworks.normativecontrol.api.students.dto.Message
import ru.maeasoftworks.normativecontrol.core.Document
import ru.maeasoftworks.normativecontrol.core.abstractions.Profile
import ru.maeasoftworks.normativecontrol.core.model.VerificationContext
import java.io.ByteArrayOutputStream
import java.io.InputStream

object VerificationService {
    data class StageHolder(var stage: Message.Stage)

    suspend fun startVerification(
        documentId: String,
        accessKey: String,
        file: InputStream,
        channel: Channel<Message>,
        profile: Profile = Profile.UrFU
    ) = coroutineScope {
        val stageHolder = StageHolder(Message.Stage.INITIALIZATION)
        val rat = Rat { parser: Document -> parser.ctx.ptr }
        val task = launch { verify(documentId, accessKey, file, stageHolder, rat, VerificationContext(profile)) }
        while (task.isActive) {
            delay(200)
            val ptr = rat.report()
            val progress = if (ptr != null) {
                (ptr.bodyPosition * 1.0 / ptr.totalChildSize).let { if (it.isNaN()) 0.0 else it }
            } else {
                0.0
            }
            channel.send(Message(documentId, Message.Code.INFO, stageHolder.stage, "PROGRESS: $progress"))
        }
        task.invokeOnCompletion {
            launch {
                channel.send(Message(documentId, Message.Code.SUCCESS, "Done"))
                channel.close()
            }
        }
    }

    private suspend fun verify(
        documentId: String,
        accessKey: String,
        file: InputStream,
        stageHolder: StageHolder,
        rat: Rat<Document, VerificationContext.Pointer>,
        ctx: VerificationContext
    ) = withContext(ctx) {
        val parser = Document(ctx = ctx) with rat
        withContext(Dispatchers.IO) { parser.load(file) }
        stageHolder.stage = Message.Stage.VERIFICATION
        parser.runVerification()
        stageHolder.stage = Message.Stage.SAVING
        val result = withContext(Dispatchers.IO) { ByteArrayOutputStream().also { parser.writeResult(it) } }

        FileStorage.uploadDocumentRender(documentId, parser.ctx.render.getString().toByteArray(), accessKey)
        FileStorage.uploadDocumentConclusion(documentId, result.toByteArray(), accessKey)
    }
}