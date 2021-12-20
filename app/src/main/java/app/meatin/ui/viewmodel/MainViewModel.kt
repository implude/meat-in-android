package app.meatin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.meatin.domain.model.AdvertisementModel
import app.meatin.domain.model.BriefPost
import app.meatin.domain.model.BriefRecipe
import app.meatin.domain.model.FakeValues
import app.meatin.domain.repositories.PostRepository
import app.meatin.domain.repositories.RecipeRepository
import app.meatin.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val postRepository: PostRepository,
    private val recipeRepository: RecipeRepository,
) : ViewModel() {

    private val _advertisement = MutableStateFlow(FakeValues.ADVERTISEMENT)
    val advertisement: StateFlow<AdvertisementModel> = _advertisement.asStateFlow()

    private val _curatedPosts = MutableStateFlow<List<BriefPost>>(listOf())
    val curatedPosts: StateFlow<List<BriefPost>> = _curatedPosts.asStateFlow()

    private val _curatedRecipes = MutableStateFlow<List<BriefRecipe>>(listOf())
    val curatedRecipes: StateFlow<List<BriefRecipe>> = _curatedRecipes.asStateFlow()

    private val _error = SingleLiveEvent<String>()
    val error: LiveData<String> = _error

    fun fetch() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            postRepository.getCuratedPosts().onSuccess {
                println(it)
                _curatedPosts.emit(it)
            }.onFailure {
                println(it)
                _error.postValue(it.message)
            }
            recipeRepository.getCuratedRecipes().onSuccess {
                _curatedRecipes.emit(it)
            }.onFailure {
                _error.postValue(it.message)
            }
            postRepository.getAdvertisement().onSuccess {
                println(it)
                _advertisement.emit(it)
            }.onFailure {
                println(it)
                _error.postValue(it.message)
            }
        }
    }
}
