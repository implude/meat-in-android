package app.meatin.domain.model

import com.google.gson.annotations.SerializedName

data class CommunityUser(
    val name: String,
    val profileImage: String,
    @SerializedName("rep_badge") val repBadge: BriefBadge,
    @SerializedName("badge_list") val badges: List<Badge>,
    @SerializedName("uploaded_post") val uploadedPosts: List<BriefPost>,
    @SerializedName("uploaded_recipe") val uploadedRecipes: List<BriefRecipe>,
)
