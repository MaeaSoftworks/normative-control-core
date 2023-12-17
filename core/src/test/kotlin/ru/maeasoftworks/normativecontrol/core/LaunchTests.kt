package ru.maeasoftworks.normativecontrol.core

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import ru.maeasoftworks.normativecontrol.core.abstractions.Profile
import ru.maeasoftworks.normativecontrol.core.implementations.ufru.BodyChapter
import ru.maeasoftworks.normativecontrol.core.model.VerificationContext
import ru.maeasoftworks.normativecontrol.hotloader.HotLoader

class LaunchTests : StringSpec({

    beforeTest {
        HotLoader.safeLoad()
    }

    "context text".config(enabled = false) {
        val ctx = VerificationContext(Profile.UrFU)
        ctx.chapter = BodyChapter
        withContext(ctx) {
            delay(500)
            coroutineContext[VerificationContext.Key]?.chapter shouldBe BodyChapter
        }
    }
})