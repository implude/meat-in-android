package app.meatin.domain.repositories

import app.meatin.domain.model.BriefCommunityUser
import app.meatin.domain.model.CommunityUser

interface UserRepository {

    fun getMyInfo(): Result<BriefCommunityUser>

    /**
     * @param image base64-encoded image
     */
    fun modifyMyInfo(
        password: String,
        email: String,
        name: String,
        image: String,
    ): Result<BriefCommunityUser>

    fun getCommunityUser(userId: String): Result<CommunityUser>
}
