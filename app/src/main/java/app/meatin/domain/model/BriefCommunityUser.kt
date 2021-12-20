package app.meatin.domain.model

import com.google.gson.annotations.SerializedName

data class BriefCommunityUser(
    val name: String,
    val photo: String?,
    @SerializedName("rep_badge") val repBadge: BriefBadge?,
    override val id: String,
) : DocumentedModel
