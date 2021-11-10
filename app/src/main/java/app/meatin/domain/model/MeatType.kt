package app.meatin.domain.model

data class MeatType(
    val label: String,
    override val id: String,
) : DocumentedModel
