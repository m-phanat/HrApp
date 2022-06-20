package com.happy.muze.app.network.data

import com.happy.muze.app.network.data.model.LoginResponse
import com.happy.muze.app.network.data.model.RequestLoginModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("/login.json")
    suspend fun login(@Body requestLogin: RequestLoginModel): Result<LoginResponse>

    @GET("/login.json")
    suspend fun login(): LoginResponse

}
