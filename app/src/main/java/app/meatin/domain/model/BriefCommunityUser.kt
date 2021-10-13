package app.meatin.domain.model

import com.google.gson.annotations.SerializedName

data class BriefCommunityUser(
    val name: String,
    val profileImage: String,
    @SerializedName("rep_badge") val repBadge: BriefBadge,
)
