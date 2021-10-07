package app.meatin.domain.model

import com.google.gson.annotations.SerializedName

data class BriefRecipe(
    val name: String,
    val thumbnail: String,
    @SerializedName("meat_type") val meatType: MeatType,
    val duration: Int,
    val difficulty: Difficulty,
    @SerializedName("created_at") val createdAt: Long,
    val heart: Heart,
)
