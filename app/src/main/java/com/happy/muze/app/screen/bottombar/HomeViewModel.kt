package com.happy.muze.app.screen.bottombar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.happy.muze.app.screen.login.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val loginRepository: LoginRepository) :
    ViewModel() {

    fun getConfig() {
        viewModelScope.launch {
            loginRepository.getConfig().onEach {
                println("getConfig $it")
            }.launchIn(this)
        }
    }
}
