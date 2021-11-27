package app.meatin.domain.model

import com.google.gson.annotations.SerializedName

data class Recipe(
    val name: String,
    val description: String,
    val thumbnail: String,
    val author: BriefCommunityUser,
    val youtube: String,
    @SerializedName("ingredient") val ingredients: List<Ingredient>,
    @SerializedName("brief_content") val briefContent: List<String>,
    @SerializedName("linked_post") val linkedPosts: List<BriefPost>,
    @SerializedName("meat_type") val meatType: MeatType,
    val duration: Int,
    val difficulty: Difficulty,
    @SerializedName("created_at") val createdAt: Long,
    val heart: Heart,
    override val id: String,
) : DocumentedModel
