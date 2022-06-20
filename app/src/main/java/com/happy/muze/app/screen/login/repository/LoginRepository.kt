package com.happy.muze.app.screen.login.repository

import android.accounts.NetworkErrorException
import com.happy.muze.app.network.data.ApiService
import com.happy.muze.app.network.data.DataService
import com.happy.muze.app.network.data.DataState
import com.happy.muze.app.network.data.model.ConfigResponse
import com.happy.muze.app.network.data.model.LoginResponse
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.net.UnknownHostException
import javax.inject.Inject


class LoginRepository @Inject constructor(
    private val apiService: ApiService,
    private val dataService: DataService
) {

    companion object {
        private const val DELAY = 1_000L
    }

    fun login(): Flow<DataState<LoginResponse>> = flow {
        emit(DataState.Loading)
        delay(DELAY)
        try {
            val result = apiService.login()
            emit(DataState.Success(result))
        } catch (e: UnknownHostException) {
            emit(DataState.Error(e))
        }
    }

    fun getConfig(): Flow<DataState<ConfigResponse>> = flow {
        emit(DataState.Loading)
        delay(DELAY)
        try {
            val result = dataService.getPlugInConfig()
            emit(DataState.Success(result))
        } catch (e: NetworkErrorException) {
            emit(DataState.Error(e))
        }
    }
}
