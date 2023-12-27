package ru.maeasoftworks.normativecontrol.api.app.web.dto

import kotlinx.serialization.Serializable
import ru.maeasoftworks.normativecontrol.api.infrastructure.security.Role

@Serializable
data class CredentialsResponse(
    val accessToken: String,

    val refreshToken: RefreshTokenResponse,

    val isCredentialsVerified: Boolean? = null,

    val role: Role? = null,

    val tokenType: String = "Bearer"
)