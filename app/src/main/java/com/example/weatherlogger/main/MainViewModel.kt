package com.example.weatherlogger.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherlogger.network.Api
import com.example.weatherlogger.network.Weather
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _wheather = MutableLiveData<Weather>()
    val weather: LiveData<Weather> = _wheather

    fun getData(city: String) {

        viewModelScope.launch {
            try {

                _wheather.value = Api.retrofitService.getCity(city, "metric", "1eec6b23fac10124e97dd7703aac86cd")
            } catch (e: Exception) {
            }
        }
    }
}