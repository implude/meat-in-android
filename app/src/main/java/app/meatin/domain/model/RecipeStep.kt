package app.meatin.domain.model

data class RecipeStep(
    val image: String,
    val title: String,
    val content: String,
)

data class RecipeStepWrapper(
    val steps: List<RecipeStep>
)
