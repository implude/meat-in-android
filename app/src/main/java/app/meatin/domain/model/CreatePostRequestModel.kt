package app.meatin.domain.model

import com.google.gson.annotations.SerializedName

data class CreatePostRequestModel(
    @SerializedName("linked_recipe") val linkedRecipeId: String,
    val content: String,
    val title: String,
    val photo: String,
)