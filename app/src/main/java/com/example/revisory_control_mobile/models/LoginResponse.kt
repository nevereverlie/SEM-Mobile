package com.example.revisory_control_mobile.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("userId") val userId: Int,
    @SerializedName("email") val email: String,
    @SerializedName("token") val token: String
)