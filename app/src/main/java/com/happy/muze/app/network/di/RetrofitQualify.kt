package com.happy.muze.app.network.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LoginOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OtherOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OtherRetrofitBuilder

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LoginRetrofitBuilder
