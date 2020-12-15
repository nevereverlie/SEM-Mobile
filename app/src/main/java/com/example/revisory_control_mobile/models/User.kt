package com.example.revisory_control_mobile.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("userId") val userId: Int,
    @SerializedName("firstname") val firstname: String?,
    @SerializedName("lastname") val lastname: String?,
    @SerializedName("userEmail") val userEmail: String?
)