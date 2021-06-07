package com.example.weatherlogger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherlogger.databinding.ActivityDetailBinding
import com.example.weatherlogger.network.Weather

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val parcelable = intent.extras!!.getParcelable<Weather>("Data")
        if (parcelable != null) {
            binding.windSpeed.text = parcelable.wind.speed.toString() + " m/s"
            //binding.temperatureValue.text = parcelable.main.temp.toString() + " C"
            binding.temperatureValue.text =
                getString(R.string.temperature, parcelable.main.temp.toString())
            binding.mainCity.text = parcelable.name
            binding.temperatureMaxValue.text = parcelable.main.temp_max.toString() + " C °"
            binding.temperatureMinValue.text = parcelable.main.temp_min.toString() + " C °"
            binding.pressureValue.text = parcelable.main.pressure.toString() + " Pa"
            binding.feelsLike.text = parcelable.main.feels_like.toString() + " C °"
            //binding.weatherDescription.text = parcelable.weather.description

        }

    }

}