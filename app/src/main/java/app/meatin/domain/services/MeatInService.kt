package app.meatin.domain.services

import app.meatin.domain.model.AuthToken
import app.meatin.domain.model.BriefCommunityUser
import app.meatin.domain.model.BriefPost
import app.meatin.domain.model.BriefRecipe
import app.meatin.domain.model.Comment
import app.meatin.domain.model.CommunityUser
import app.meatin.domain.model.CreateCommentRequestModel
import app.meatin.domain.model.CreatePostRequestModel
import app.meatin.domain.model.CreateRecipeRequestModel
import app.meatin.domain.model.CreateUserRequestModel
import app.meatin.domain.model.Difficulty
import app.meatin.domain.model.LoginRequestModel
import app.meatin.domain.model.ModifyMyInfoRequestModel
import app.meatin.domain.model.Post
import app.meatin.domain.model.Recipe
import app.meatin.domain.model.RecipeStep
import app.meatin.domain.model.RecipeStepWrapper
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface MeatInService {

    @GET("post/curated")
    fun getCuratedPosts(): Call<List<BriefPost>>

    @GET("post/{id}")
    fun getPostById(@Path("id") id: String): Call<Post>

    @POST("post")
    fun createPost(@Body createPostRequestModel: CreatePostRequestModel): Call<Post>

    @POST("post/{id}/comment")
    fun createComment(
        @Path("id") id: String,
        @Body createCommentRequestModel: CreateCommentRequestModel,
    ): Call<Comment>

    @POST("post/{id}/heart")
    fun heartPost(@Path("id") id: String): Call<Unit>

    @DELETE("post/{id}/heart")
    fun unheartPost(@Path("id") id: String): Call<Unit>

    @POST("post/{id}/bookmark")
    fun bookmarkPost(@Path("id") id: String): Call<Unit>

    @DELETE("post/{id}/bookmark")
    fun unbookmarkPost(@Path("id") id: String): Call<Unit>

    @GET("recipe/curated")
    fun getCuratedRecipes(): Call<List<BriefRecipe>>

    @GET("recipe/{id}")
    fun getRecipeById(@Path("id") id: String): Call<Recipe>

    @GET("recipe/{id}/step")
    fun getRecipeSteps(@Path("id") id: String): Call<RecipeStepWrapper>

    @POST("recipe")
    fun createRecipe(@Body createRecipeRequestModel: CreateRecipeRequestModel): Call<Recipe>

    @GET("recipe/difficulty")
    fun getDifficulties(): Call<List<Difficulty>>

    @GET("user/me")
    fun getMyInfo(): Call<BriefCommunityUser>

    @PATCH("user/me")
    fun modifyMyInfo(@Body modifyMyInfoRequestModel: ModifyMyInfoRequestModel): Call<BriefCommunityUser>

    @POST("recipe/{id}/heart")
    fun heartRecipe(@Path("id") id: String): Call<Unit>

    @DELETE("recipe/{id}/heart")
    fun unheartRecipe(@Path("id") id: String): Call<Unit>

    @POST("recipe/{id}/bookmark")
    fun bookmarkRecipe(@Path("id") id: String): Call<Unit>

    @DELETE("recipe/{id}/bookmark")
    fun unbookmarkRecipe(@Path("id") id: String): Call<Unit>

    @GET("user/{id}")
    fun getCommunityUser(@Path("id") id: String): Call<CommunityUser>

    @POST("user")
    fun createUser(@Body createUserRequestModel: CreateUserRequestModel): Call<AuthToken>

    @POST("user/login")
    fun login(@Body loginRequestModel: LoginRequestModel): Call<AuthToken>
}
