package app.meatin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.meatin.domain.model.Recipe
import app.meatin.domain.model.RecipeStep
import app.meatin.domain.repositories.RecipeRepository
import app.meatin.util.SingleLiveEvent
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val repository: RecipeRepository,
) : ViewModel() {

    private val _recipe = MutableLiveData<Recipe>()
    val recipe: LiveData<Recipe> = _recipe

    private val _recipeSteps = MutableLiveData<List<RecipeStep>>()
    val recipeSteps: LiveData<List<RecipeStep>> = _recipeSteps

    private val _error = SingleLiveEvent<String>()
    val error: LiveData<String> = _error

    fun fetch(id: String) = viewModelScope.launch {
        repository.getRecipe(id).onSuccess {
            _recipe.value = it
        }.onFailure {
            _error.value = it.message
        }
    }
}