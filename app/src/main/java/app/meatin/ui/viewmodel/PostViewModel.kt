package app.meatin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.meatin.domain.model.FakeValues
import app.meatin.domain.model.Post
import app.meatin.domain.repositories.PostRepository
import app.meatin.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostViewModel(
    private val postRepository: PostRepository,
) : ViewModel() {

    private val _post = MutableStateFlow(FakeValues.POST)
    val post: StateFlow<Post> = _post

    private val _error = SingleLiveEvent<String>()
    val error: LiveData<String> = _error

    fun fetch(id: String) = viewModelScope.launch {
        _post.emit(FakeValues.POST)
        withContext(Dispatchers.IO) {
            postRepository.getPost(id).onSuccess {
                _post.emit(it)
            }.onFailure {
                _error.postValue(it.message)
            }
        }
    }
}
