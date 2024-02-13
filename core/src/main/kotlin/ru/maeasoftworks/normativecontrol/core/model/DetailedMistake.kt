package ru.maeasoftworks.normativecontrol.core.model

import kotlinx.serialization.Serializable
import ru.maeasoftworks.normativecontrol.core.abstractions.MistakeReason

@Serializable
data class DetailedMistake(
    val mistakeReason: MistakeReason,
    val id: String,
    val expected: String? = null,
    val actual: String? = null
)