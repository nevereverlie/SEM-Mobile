package com.example.revisory_control_mobile.models

import com.google.gson.annotations.SerializedName

data class Department (
    @SerializedName("departmentId") val departmentId: Int,
    @SerializedName("departmentName") val departmentName: String
)