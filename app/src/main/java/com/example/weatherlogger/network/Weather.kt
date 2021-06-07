package com.example.weatherlogger.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weather(
    val name: String,
    val wind: Wind,
    val main: MainWeather,
    val visibility: Int,
    val sys: Sys,
    val weather: List<Weather2>,


): Parcelable