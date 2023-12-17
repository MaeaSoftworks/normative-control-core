package ru.maeasoftworks.normativecontrol.core.implementations.ufru

import org.docx4j.wml.R
import ru.maeasoftworks.normativecontrol.core.abstractions.Handler
import ru.maeasoftworks.normativecontrol.core.abstractions.Profile

object RHandler : Handler<R>({ register<R>(Profile.UrFU, RHandler) }) {
    override suspend fun handle(element: Any) {

    }
}