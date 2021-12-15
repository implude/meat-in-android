package app.meatin.domain.model

data class BriefBadge(
    val image: String,
    val label: String,
    override val id: String,
) : DocumentedModel
