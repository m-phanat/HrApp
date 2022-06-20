package com.happy.muze.app.network.data

import com.happy.muze.app.network.data.model.ConfigResponse
import retrofit2.http.POST

interface DataService {

    @POST("users/getpluginconfig")
    suspend fun getPlugInConfig(): ConfigResponse
}
