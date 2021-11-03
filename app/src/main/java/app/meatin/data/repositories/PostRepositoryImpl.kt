package app.meatin.data.repositories

import app.meatin.domain.model.BriefPost
import app.meatin.domain.model.Comment
import app.meatin.domain.model.CreateCommentRequestModel
import app.meatin.domain.model.CreatePostRequestModel
import app.meatin.domain.model.Post
import app.meatin.domain.repositories.PostRepository
import app.meatin.domain.services.MeatInService
import app.meatin.util.launch

class PostRepositoryImpl(
    private val service: MeatInService,
) : PostRepository {

    override fun getCuratedPosts(): Result<List<BriefPost>> = launch(service.getCuratedPosts())

    override fun getPost(id: String): Result<Post> = launch(service.getPostById(id))

    override fun createPost(linkedRecipeId: String, title: String, content: String, photo: String): Result<Post> =
        launch(
            service.createPost(
                CreatePostRequestModel(linkedRecipeId, content, title, photo)
            )
        )

    override fun createComment(postId: String, content: String): Result<Comment> = launch(
        service.createComment(
            postId,
            CreateCommentRequestModel(content),
        )
    )

    override fun heartPost(postId: String): Result<Unit> = launch(service.heartPost(postId))

    override fun unheartPost(postId: String): Result<Unit> = launch(service.unheartPost(postId))

    override fun bookmarkPost(postId: String): Result<Unit> = launch(service.bookmarkPost(postId))

    override fun unbookmarkPost(postId: String): Result<Unit> = launch(service.unbookmarkPost(postId))
}
