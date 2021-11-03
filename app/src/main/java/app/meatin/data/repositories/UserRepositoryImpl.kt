package app.meatin.data.repositories

import app.meatin.domain.model.BriefCommunityUser
import app.meatin.domain.model.CommunityUser
import app.meatin.domain.model.ModifyMyInfoRequestModel
import app.meatin.domain.repositories.UserRepository
import app.meatin.domain.services.MeatInService
import app.meatin.util.launch

class UserRepositoryImpl(
    private val service: MeatInService,
) : UserRepository {
    override fun getMyInfo(): Result<BriefCommunityUser> = launch(service.getMyInfo())

    override fun modifyMyInfo(
        password: String,
        email: String,
        name: String,
        image: String,
    ): Result<BriefCommunityUser> = launch(
        service.modifyMyInfo(
            ModifyMyInfoRequestModel(
                email = email, name = name, photo = image
            )
        )
    )

    override fun getCommunityUser(userId: String): Result<CommunityUser> = launch(
        service.getCommunityUser(userId)
    )
}