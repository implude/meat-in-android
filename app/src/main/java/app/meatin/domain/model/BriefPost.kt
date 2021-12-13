package app.meatin.domain.model

import com.google.gson.annotations.SerializedName

data class BriefPost(
    val author: BriefCommunityUser,
    val content: String,
    val photo: String,
    @SerializedName("created_at") val createdAt: Long,
    val heart: Heart,
    @SerializedName("comment_count") val nComments: Int,
    override val id: String,
) : DocumentedModel
