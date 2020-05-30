package com.example.retrofitprayertime.datas


import com.google.gson.annotations.SerializedName

data class DataClass(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("status")
    val status: String
)