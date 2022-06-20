package com.happy.muze.app.screen.profile

import com.happy.muze.app.network.data.model.LoginResponse
import com.happy.muze.app.utils.SessionManager
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val sessionManager: SessionManager
) {
    fun saveUser(loginEntity: LoginResponse) {
        sessionManager.createLoginSession(
            name = loginEntity.name ?: "",
            token = loginEntity.token ?: ""
        )
    }

    fun getToken(): String {
        return sessionManager.getToken()
    }

    fun isLoggedIn(): Boolean {
        return sessionManager.isLoggedIn()
    }
}
