package app.meatin.domain.model

import com.google.gson.annotations.SerializedName

data class BriefPost(
    val author: BriefCommunityUser,
    @SerializedName("created_at") val createdAt: Long,
    val heart: Heart,
    @SerializedName("comment_count") val nComments: Int,
    val content: String,
    val photo: String,
)
