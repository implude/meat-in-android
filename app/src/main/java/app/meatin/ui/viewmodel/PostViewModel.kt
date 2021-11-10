package app.meatin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.meatin.domain.model.Post
import app.meatin.domain.repositories.PostRepository
import app.meatin.util.SingleLiveEvent
import kotlinx.coroutines.launch

class PostViewModel(
    private val postRepository: PostRepository,
) : ViewModel() {

    private val _post = MutableLiveData<Post>()
    val post: LiveData<Post> = _post

    private val _error = SingleLiveEvent<String>()
    val error: LiveData<String> = _error

    fun fetch(id: String) = viewModelScope.launch {
        postRepository.getPost(id).onSuccess {
            _post.value = it
        }.onFailure {
            _error.value = it.message
        }
    }
}
