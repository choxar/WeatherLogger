package com.example.weatherlogger.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://api.openweathermap.org/data/2.5/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private fun buildOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    return OkHttpClient.Builder().addInterceptor(interceptor).build()
}

private val retrofit = Retrofit.Builder()
    .client(buildOkHttpClient())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    //    @GET("weather?q=riga&units=metric&appid=517fb30e6b4cab9136a75348454d4227")
//    suspend fun getCity(): Weather
    @GET("weather")
    suspend fun getCity(
        @Query("q") q: String,
        @Query("units") units: String,
        @Query("appid") appid: String
    ): Weather
}

object Api {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}