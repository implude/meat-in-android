package app.meatin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.meatin.domain.model.BriefPost
import app.meatin.domain.model.BriefRecipe
import app.meatin.domain.repositories.PostRepository
import app.meatin.domain.repositories.RecipeRepository
import app.meatin.util.SingleLiveEvent
import kotlinx.coroutines.launch

class MainViewModel(
    private val postRepository: PostRepository,
    private val recipeRepository: RecipeRepository,
) : ViewModel() {

    private val _curatedPosts = MutableLiveData<List<BriefPost>>()
    val curatedPosts: LiveData<List<BriefPost>> = _curatedPosts

    private val _curatedRecipes = MutableLiveData<List<BriefRecipe>>()
    val curatedRecipes: LiveData<List<BriefRecipe>> = _curatedRecipes

    private val _error = SingleLiveEvent<String>()
    val error: LiveData<String> = _error

    fun fetch() = viewModelScope.launch {
        postRepository.getCuratedPosts().onSuccess {
            _curatedPosts.postValue(it)
        }.onFailure {
            _error.postValue(it.message)
        }
        recipeRepository.getCuratedRecipes().onSuccess {
            _curatedRecipes.postValue(it)
        }.onFailure {
            _error.postValue(it.message)
        }
    }
}
