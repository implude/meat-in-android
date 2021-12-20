package app.meatin.domain.model

import com.google.gson.annotations.SerializedName

data class AdvertisementModel(
    val title: String,
    val description: String,
    val image: String,
    @SerializedName("target_url") val targetUrl: String,
    override val id: String,
) : DocumentedModel
