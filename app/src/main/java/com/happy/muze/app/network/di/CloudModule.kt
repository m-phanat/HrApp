package com.happy.muze.app.network.di

import androidx.viewbinding.BuildConfig
import com.google.gson.Gson
import com.happy.muze.app.network.AuthInterceptor
import com.happy.muze.app.network.data.DataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class CloudModule {

    companion object {
        private const val baseUrl = "http://cloud.ezy-hr.com:3000/"
    }

    @OtherOkHttpClient
    @Provides
    fun getClientForJwt(authInterceptor: AuthInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(authInterceptor)
        httpClient.retryOnConnectionFailure(true)
        return httpClient.build()
    }

    @OtherRetrofitBuilder
    @Provides
    fun provideGetData(
        gson: Gson, @OtherOkHttpClient okHttpClient: OkHttpClient
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Provides
    fun provideDataService(
        @OtherRetrofitBuilder retrofit: Retrofit.Builder
    ): DataService {
        return retrofit.build()
            .create(DataService::class.java)
    }
}
