package app.meatin.domain.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("photo") val photos: List<String>?,
    val title: String,
    @SerializedName("created_at") val createdAt: Long,
    val author: BriefCommunityUser,
    val content: String,
    @SerializedName("linked_recipe") val linkedRecipe: BriefRecipe,
    @SerializedName("comment") val comments: List<Comment>,
    val heart: Heart?,
    val bookmarked: Boolean,
    override val id: String,
) : DocumentedModel
