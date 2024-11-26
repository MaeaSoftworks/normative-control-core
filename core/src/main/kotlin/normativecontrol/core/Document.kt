package normativecontrol.core

import normativecontrol.core.contexts.VerificationContext
import normativecontrol.core.exceptions.CoreException
import normativecontrol.core.locales.Locales
import normativecontrol.core.mocktypes.Metadata
import org.docx4j.openpackaging.packages.WordprocessingMLPackage
import java.io.ByteArrayOutputStream
import java.io.InputStream

internal class Document(runtime: Runtime, file: InputStream, locale: Locales) {
    val mistakeCount: Int
        get() = ctx.lastMistakeId.toInt()

    val render: String
        get() = ctx.render.render()

    private val mlPackage: WordprocessingMLPackage = WordprocessingMLPackage.load(file)
    private val ctx = VerificationContext(runtime, mlPackage, locale)

    init {
        runtime.context = ctx
    }

    internal fun runVerification() {
        with(ctx) {
            // region metadata verification
            val metadata = Metadata((doc.`package` as WordprocessingMLPackage).docPropsCorePart?.contents)
            runtime.handlers[metadata]?.handleElement(metadata)
            // endregion
            if (doc.content.isEmpty()) {
                throw CoreException.IncorrectDocumentPart(locale)
            }

            doc.content.iterate { element, _ ->
                runtime.handlers[element]?.handleElement(element)
            }
        }
    }

    internal fun writeResult(stream: ByteArrayOutputStream) {
        mlPackage.save(stream)
    }
}