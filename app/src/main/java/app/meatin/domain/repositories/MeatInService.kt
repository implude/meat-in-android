package app.meatin.domain.repositories

import app.meatin.domain.model.AuthToken
import app.meatin.domain.model.BriefCommunityUser
import app.meatin.domain.model.BriefPost
import app.meatin.domain.model.BriefRecipe
import app.meatin.domain.model.Comment
import app.meatin.domain.model.CommunityUser
import app.meatin.domain.model.Difficulty
import app.meatin.domain.model.Ingredient
import app.meatin.domain.model.Post
import app.meatin.domain.model.Recipe
import app.meatin.domain.model.RecipeStep
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface MeatInService {

    @GET("/post/curated")
    fun getCuratedPosts(): List<BriefPost>

    @GET("/post/{id}")
    fun getPostById(@Path("id") id: String): Post

    /**
     * @param photo base64 encoded image
     */
    @FormUrlEncoded
    @POST("/post")
    fun createPost(
        @Field("linked_recipe") linkedRecipeId: String,
        @Field("content") content: String,
        @Field("title") title: String,
        @Field("photo") photo: String,
    ): Post

    @POST("/post/{id}/comment")
    fun createComment(@Path("id") id: String, @Field("content") content: String): Comment

    @GET("/recipe/curated")
    fun getCuratedRecipes(): List<BriefRecipe>

    @GET("/recipe/{id}")
    fun getRecipeById(@Path("id") id: String): Recipe

    @GET("/recipe/{id}/step")
    fun getRecipeSteps(): List<RecipeStep>

    /**
     * @param duration Duration in second
     * @param thumbnail Base64 encoded image
     */
    @FormUrlEncoded
    @POST("/recipe")
    fun createRecipe(
        @Field("ingredient") ingredients: List<Ingredient>,
        @Field("youtube") youtube: String,
        @Field("difficulty") difficultyNumber: Int,
        @Field("duration") duration: String,
        @Field("description") description: String,
        @Field("name") name: String,
        @Field("thumbnail") thumbnail: String,
    )

    @FormUrlEncoded
    @GET("/recipe/difficulty")
    fun getDifficulties(): List<Difficulty>

    @GET("/user/me")
    fun getMyInfo(): BriefCommunityUser

    @PATCH("/user/me")
    fun modifyMyInfo(
        @Field("email") email: String,
        @Field("name") name: String,
        @Field("image") image: String,
    ): BriefCommunityUser

    @GET("/user/{id}")
    fun getCommunityUser(@Path("id") id: String): CommunityUser

    @POST("/user")
    fun createUser(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("username") username: String,
    ): AuthToken

    @POST("/user/login")
    fun login(@Field("username") username: String, @Field("password") password: String): AuthToken

    @POST("/user/login")
    fun login(@Field("refreshToken") refreshToken: String): AuthToken
}
