package app.meatin.domain.model

data class Badge(
    val image: String,
    val label: String,
    val description: String,
    override val id: String,
) : DocumentedModel
