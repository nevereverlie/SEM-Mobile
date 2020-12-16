package com.example.revisory_control_mobile.models

import com.google.gson.annotations.SerializedName

data class Schedule (
    @SerializedName("weekDayId") val weekDayId: Int?,
    @SerializedName("timeFrom") val timeFrom: String?,
    @SerializedName("timeTo") val timeTo: String?
)