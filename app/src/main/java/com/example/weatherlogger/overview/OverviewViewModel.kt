package com.example.weatherlogger.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherlogger.network.Api
import com.example.weatherlogger.network.Weather
import kotlinx.coroutines.launch

enum class WeatherApiStatus { LOADING, ERROR, DONE }


class OverviewViewModel : ViewModel() {



    private val _status = MutableLiveData<WeatherApiStatus>()
    val status: LiveData<WeatherApiStatus> = _status
    private val _wheather = MutableLiveData<Weather>()
    val weather: LiveData<Weather> = _wheather



    fun getData(city: String) {

        viewModelScope.launch {
            _status.value = WeatherApiStatus.LOADING
            try {

                _wheather.value = Api.retrofitService.getCity(city, "metric", "517fb30e6b4cab9136a75348454d4227")
                _status.value = WeatherApiStatus.DONE
            } catch (e: Exception) {
                _status.value = WeatherApiStatus.ERROR
            }
        }
    }
}