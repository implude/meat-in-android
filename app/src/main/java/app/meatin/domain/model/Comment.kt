package app.meatin.domain.model

import com.google.gson.annotations.SerializedName

data class Comment(
    val title: String,
    @SerializedName("created_at") val createdAt: Long,
    val author: BriefCommunityUser,
    val content: String,
)
