package app.meatin.domain.repositories

import app.meatin.domain.model.BriefPost
import app.meatin.domain.model.Comment
import app.meatin.domain.model.Post

interface PostRepository {
    fun getCuratedPosts(): Result<List<BriefPost>>
    fun getPost(id: String): Result<Post>

    /**
     * @param photo base64-encoded image
     */
    fun createPost(linkedRecipeId: String, title: String, content: String, photo: String): Result<Post>

    fun createComment(postId: String, content: String): Result<Comment>

    fun heartPost(postId: String): Result<Unit>

    fun unheartPost(postId: String): Result<Unit>

    fun bookmarkPost(postId: String): Result<Unit>

    fun unbookmarkPost(postId: String): Result<Unit>
}
