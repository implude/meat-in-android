package app.meatin.domain.model

data class CreateUserRequestModel(
    val email: String,
    val password: String,
    val name: String,
    val photo: String,
)
