package app.meatin.domain.model

import com.google.gson.annotations.SerializedName

data class CreateRecipeRequestModel(
    @SerializedName("ingredient") val ingredients: List<Ingredient>,
    val youtube: String,
    @SerializedName("difficulty") val difficultyNumber: Int,
    val duration: Int,
    val description: String,
    val name: String,
    val thumbnail: String,
)
