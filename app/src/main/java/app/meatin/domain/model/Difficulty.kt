package app.meatin.domain.model

import com.google.gson.annotations.SerializedName

data class Difficulty(
    val label: String,
    @SerializedName("numeric_level") val numericLevel: Int,
)
