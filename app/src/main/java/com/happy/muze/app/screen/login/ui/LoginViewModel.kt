package com.happy.muze.app.screen.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.happy.muze.app.network.data.DataState
import com.happy.muze.app.screen.login.repository.LoginRepository
import com.happy.muze.app.screen.profile.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private var _loginStateResponse =
        MutableLiveData<Boolean>()
    val loginStateResponse: MutableLiveData<Boolean> get() = _loginStateResponse

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun login() {
        viewModelScope.launch {
            _isLoading.value = true
            loginRepository.login()
                .onEach {
                    when (it) {
                        is DataState.Success -> {
                            println("login success")
                            userRepository.saveUser(it.data)
                            loginStateResponse.value = true
                        }
                        is DataState.Error -> {
                            println("login error")
                        }
                        is DataState.Loading -> {
                            println("login loading")
                        }
                    }
                    _isLoading.value = false
                }.launchIn(this)
        }
    }

    fun isLoggedIn(): Boolean {
        return userRepository.isLoggedIn()
    }
}
