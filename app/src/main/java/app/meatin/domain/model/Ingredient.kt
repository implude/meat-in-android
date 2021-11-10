package app.meatin.domain.model

data class Ingredient(
    val label: String,
    val amount: String,
    val content: String?,
    val required: Boolean,
    override val id: String,
) : DocumentedModel
