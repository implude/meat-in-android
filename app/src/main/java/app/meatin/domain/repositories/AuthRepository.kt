package app.meatin.domain.repositories

import app.meatin.domain.model.AuthToken

interface AuthRepository {

    /**
     * @param photo base64-encoded image
     */
    fun createUser(
        name: String,
        photo: String,
        email: String,
        password: String,
    ): Result<AuthToken>

    fun login(
        email: String,
        password: String,
    ): Result<AuthToken>
}
