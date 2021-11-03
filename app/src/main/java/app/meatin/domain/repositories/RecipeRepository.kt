package app.meatin.domain.repositories

import app.meatin.domain.model.BriefRecipe
import app.meatin.domain.model.Difficulty
import app.meatin.domain.model.Ingredient
import app.meatin.domain.model.Recipe
import app.meatin.domain.model.RecipeStep

interface RecipeRepository {

    fun getCuratedRecipe(): Result<List<BriefRecipe>>

    fun getRecipe(recipeId: String): Result<Recipe>

    fun getRecipeSteps(recipeId: String): Result<List<RecipeStep>>

    /**
     * @param thumbnail base64-encoded image
     */
    fun createRecipe(
        ingredient: List<Ingredient>,
        youtube: String,
        difficultyNumber: Int,
        duration: Int,
        description: String,
        name: String,
        thumbnail: String,
    ): Result<Recipe>

    fun getDifficulties(): Result<Difficulty>

    fun heartRecipe(recipeId: String): Result<Unit>

    fun unheartRecipe(recipeId: String): Result<Unit>

    fun bookmarkRecipe(recipeId: String): Result<Unit>

    fun unbookmarkRecipe(recipeId: String): Result<Unit>
}
