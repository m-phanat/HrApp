package com.happy.muze.app.network

import com.happy.muze.app.screen.profile.UserRepository
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


class AuthInterceptor
@Inject constructor(
    private val userRepository: UserRepository
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        userRepository.getToken().let {
            requestBuilder.addHeader("Authorization", "JWT $it")
        }

        return chain.proceed(requestBuilder.build())
    }
}
