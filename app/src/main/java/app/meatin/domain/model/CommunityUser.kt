package app.meatin.domain.model

import com.google.gson.annotations.SerializedName

data class CommunityUser(
    val name: String,
    val profileImage: String,
    @SerializedName("rep_badge") val repBadge: BriefBadge,
)
