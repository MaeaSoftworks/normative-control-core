package ru.maeasoftworks.normativecontrol.api.app

import io.ktor.server.application.Application
import ru.maeasoftworks.normativecontrol.hotloader.HotLoader

inline fun <DaggerComponentBuilder : ApplicationConfiguration.Builder> Application.initializeApplication(
    createComponentBuilder: () -> DaggerComponentBuilder,
    initComponent: (DaggerComponentBuilder) -> Unit = { }
) {
    val builder = createComponentBuilder()
    builder.application(this)
    initComponent(builder)
    builder.build().also { it.initializer.apply { register() } }
    HotLoader.safeLoad()
}