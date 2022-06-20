package com.happy.muze.app.network.data

sealed class DataState<out R> {

    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: Exception? = null) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}
