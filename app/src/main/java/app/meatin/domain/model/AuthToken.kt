package app.meatin.domain.model

data class AuthToken(
    val accessToken: String,
    val refreshToken: String,
)
