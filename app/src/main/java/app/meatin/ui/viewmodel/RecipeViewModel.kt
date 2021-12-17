package app.meatin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.meatin.domain.model.FakeValues
import app.meatin.domain.model.Recipe
import app.meatin.domain.model.RecipeStep
import app.meatin.domain.repositories.RecipeRepository
import app.meatin.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RecipeViewModel(
    private val repository: RecipeRepository,
) : ViewModel() {

    private val _recipe = MutableStateFlow<Recipe>(FakeValues.RECIPE)
    val recipe: StateFlow<Recipe> = _recipe

    private val _recipeSteps = MutableStateFlow<List<RecipeStep>>(listOf())
    val recipeSteps: StateFlow<List<RecipeStep>> = _recipeSteps

    private val _error = SingleLiveEvent<String>()
    val error: LiveData<String> = _error

    fun fetch(id: String) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.getRecipe(id).onSuccess {
                _recipe.emit(it)
                println(it)
            }.onFailure {
                _error.postValue(it.message)
                println(it)
            }
            repository.getRecipeSteps(id).onSuccess {
                _recipeSteps.emit(it.steps)
            }.onFailure {
                _error.postValue(it.message)
            }
        }
    }
}
