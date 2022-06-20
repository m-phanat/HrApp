package com.happy.muze.app.network.data.model


import com.google.gson.annotations.SerializedName

data class RequestLoginModel(
    @SerializedName("app_version")
    val appVersion: String? = null,
    @SerializedName("isRooted")
    val isRooted: Boolean? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("manufacturer")
    val manufacturer: String? = null,
    @SerializedName("model")
    val model: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("platform")
    val platform: String? = null,
    @SerializedName("tenant")
    val tenant: String? = null,
    @SerializedName("tfatoken")
    val tfatoken: String? = null,
    @SerializedName("username")
    val username: String? = null,
    @SerializedName("version")
    val version: String? = null
)
