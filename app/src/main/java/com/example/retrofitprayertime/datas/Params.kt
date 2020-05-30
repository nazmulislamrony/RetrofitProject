package com.example.retrofitprayertime.datas


import com.google.gson.annotations.SerializedName

data class Params(
    @SerializedName("Fajr")
    val fajr: Int,
    @SerializedName("Isha")
    val isha: Int
)