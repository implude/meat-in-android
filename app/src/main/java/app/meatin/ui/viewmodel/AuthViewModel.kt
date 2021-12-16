package app.meatin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.meatin.data.network.AuthenticationStore
import app.meatin.domain.repositories.AuthRepository
import app.meatin.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthViewModel(
    private val authRepository: AuthRepository,
) : ViewModel() {

    private val _error = SingleLiveEvent<String>()
    val error: LiveData<String> = _error

    private val _authSuccessEvent = SingleLiveEvent<Unit>()
    val authSuccessEvent: LiveData<Unit> = _authSuccessEvent

    fun login(email: String, password: String) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            authRepository.login(email, password).onSuccess {
                AuthenticationStore.token = it
                _authSuccessEvent.call()
            }.onFailure {
                println(it)
                _error.postValue(it.message)
            }
        }
    }

    fun register(email: String, password: String) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            authRepository.createUser(
                email.split("@").first(), "a",
                email, password
            ).onSuccess {
                AuthenticationStore.token = it
                _authSuccessEvent.call()
            }.onFailure {
                println(it)
                _error.postValue(it.message)
            }
        }
    }
}
