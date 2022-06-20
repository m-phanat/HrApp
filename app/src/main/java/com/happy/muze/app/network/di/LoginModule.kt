package com.happy.muze.app.network.di

import androidx.viewbinding.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.happy.muze.app.network.data.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LoginModule {

    //TODO change baseUrl to http://cloud.ezy-hr.com:3000/
    companion object {
        private const val baseUrl = "https://mvvm-project-4769a.firebaseio.com/"
    }

    @Provides
    @Singleton
    fun provideGsonBuilder(): Gson = GsonBuilder().create()

    @LoginOkHttpClient
    @Provides
    fun getClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.retryOnConnectionFailure(true)
        return httpClient.build()
    }


    @LoginRetrofitBuilder
    @Provides
    fun provideGetToken(
        gson: Gson, @LoginOkHttpClient okHttpClient: OkHttpClient
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Provides
    fun provideApiService(
        @LoginRetrofitBuilder retrofit: Retrofit.Builder
    ): ApiService {
        return retrofit.build()
            .create(ApiService::class.java)
    }
}
