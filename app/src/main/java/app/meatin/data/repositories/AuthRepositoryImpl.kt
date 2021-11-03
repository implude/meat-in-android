package app.meatin.data.repositories

import app.meatin.domain.model.AuthToken
import app.meatin.domain.model.CreateUserRequestModel
import app.meatin.domain.model.LoginRequestModel
import app.meatin.domain.repositories.AuthRepository
import app.meatin.domain.services.MeatInService
import app.meatin.util.launch

class AuthRepositoryImpl(
    private val service: MeatInService,
) : AuthRepository {

    override fun createUser(name: String, photo: String, email: String, password: String): Result<AuthToken> =
        launch(
            service.createUser(
                CreateUserRequestModel(
                    email = email,
                    password = password,
                    name = name,
                    photo = photo,
                )
            )
        )

    override fun login(email: String, password: String): Result<AuthToken> = launch(
        service.login(
            LoginRequestModel(
                email = email,
                password = password,
            )
        )
    )
}
