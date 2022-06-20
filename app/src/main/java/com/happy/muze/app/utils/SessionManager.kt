package com.happy.muze.app.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SessionManager @Inject constructor(@ApplicationContext private val context: Context) {

    private var pref: SharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
    private var editor: SharedPreferences.Editor = pref.edit()

    companion object {
        private const val PREF_NAME: String = "app"
        private const val KEY_IS_LOGIN: String = "isLogin"
        private const val KEY_NAME: String = "name"
        private const val KEY_TOKEN: String = "token"
        private const val PRIVATE_MODE: Int = 0
    }

    fun createLoginSession(name: String, token: String) {
        editor.putBoolean(KEY_IS_LOGIN, true)
        editor.putString(KEY_NAME, name)
        editor.putString(KEY_TOKEN, token)
        editor.commit()
    }

    fun isLoggedIn(): Boolean {
        return pref.getBoolean(KEY_IS_LOGIN, false)
    }

    fun getToken(): String {
        return pref.getString(KEY_TOKEN, "").orEmpty()
    }
}
