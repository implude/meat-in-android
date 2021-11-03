package app.meatin.data.repositories

import app.meatin.domain.model.BriefRecipe
import app.meatin.domain.model.CreateRecipeRequestModel
import app.meatin.domain.model.Difficulty
import app.meatin.domain.model.Ingredient
import app.meatin.domain.model.Recipe
import app.meatin.domain.model.RecipeStep
import app.meatin.domain.repositories.RecipeRepository
import app.meatin.domain.services.MeatInService
import app.meatin.util.launch

class RecipeRepositoryImpl(
    private val service: MeatInService,
) : RecipeRepository {

    override fun getCuratedRecipes(): Result<List<BriefRecipe>> = launch(service.getCuratedRecipes())

    override fun getRecipe(recipeId: String): Result<Recipe> = launch(service.getRecipeById(recipeId))

    override fun getRecipeSteps(recipeId: String): Result<List<RecipeStep>> = launch(service.getRecipeSteps(recipeId))

    override fun createRecipe(
        ingredient: List<Ingredient>,
        youtube: String,
        difficultyNumber: Int,
        duration: Int,
        description: String,
        name: String,
        thumbnail: String,
    ): Result<Recipe> = launch(
        service.createRecipe(
            CreateRecipeRequestModel(ingredient, youtube, difficultyNumber, duration, description, name, thumbnail)
        )
    )

    override fun getDifficulties(): Result<List<Difficulty>> = launch(service.getDifficulties())

    override fun heartRecipe(recipeId: String): Result<Unit> = launch(service.heartRecipe(recipeId))

    override fun unheartRecipe(recipeId: String): Result<Unit> = launch(service.unheartRecipe(recipeId))

    override fun bookmarkRecipe(recipeId: String): Result<Unit> = launch(service.bookmarkRecipe(recipeId))

    override fun unbookmarkRecipe(recipeId: String): Result<Unit> = launch(service.unbookmarkRecipe(recipeId))
}