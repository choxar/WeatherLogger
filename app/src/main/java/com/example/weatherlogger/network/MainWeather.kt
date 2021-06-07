package com.example.weatherlogger.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainWeather (
    val temp: Double,
    val feels_like: Double,
    val temp_min:Double,
    val temp_max: Double,
    val pressure: Int,


): Parcelable