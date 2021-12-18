package app.meatin.domain.model

data class RecipeStep(
    val image: String,
    val title: String,
    val content: String,
    val timer: List<Timer>?,
) : RecipeDisplayable

data class Timer(
    val description: String?,
    /**
     * Duration in millisecond.
     */
    val duration: Long,
) : RecipeDisplayable

data class RecipeStepWrapper(
    val steps: List<RecipeStep>,
)
