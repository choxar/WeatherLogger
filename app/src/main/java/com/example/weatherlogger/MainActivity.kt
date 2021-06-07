package com.example.weatherlogger

//http://api.openweathermap.org/data/2.5/weather?q=Riga&appid=1eec6b23fac10124e97dd7703aac86cd

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherlogger.databinding.ActivityMainBinding
import com.example.weatherlogger.main.MainViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var textView: TextView

    private lateinit var textView1: TextView

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        // link the textView in which the
        // temperature will be displayed
        textView = findViewById(R.id.temperature_value)
        textView1 = findViewById(R.id.main_city)


        // on clicking this button function to
        // get the coordinates will be called


        binding.search.setOnClickListener {

            viewModel.getData(binding.name.text.toString())


        }

        binding.detailsButton.setOnClickListener {

            //All actions preformed when pressing More details Button

            openDetailActivity()

        }

    }


    private fun openDetailActivity() {

        val intent = Intent(this, DetailActivity::class.java).apply {

            putExtra("Data", viewModel.weather.value)

        }

        startActivity(intent)

    }

//    fun fetchJson() {
//
//        println("Attempting to Fetch Json")
//
//        val url =
//            "http://api.openweathermap.org/data/2.5/weather?q=Riga&appid=1eec6b23fac10124e97dd7703aac86cd"
//
//        val request = Request.Builder().url(url).build()
//
//        val client = OkHttpClient()
//        client.newCall(request).enqueue(object : Callback {
//
//            override fun onResponse(call: Call, response: Response) {
//
//                val body = response?.body?.string()
//                println(body)
//
//                val gson = GsonBuilder().create()
//
//                val weatherHome = gson.fromJson(body, WeatherHome::class.java)
//
//                runOnUiThread {
//
//                    //Tutorial That I watched had here:
//                    // recyclerView_main.adapter = MainAdapter(weatherHome)
//
//                }
//            }
//
//            override fun onFailure(call: Call, e: IOException) {
//
//                println("Failed to execute request")
//
//            }
//
//        })
//    }


}


//class WeatherHome(val temp: List<Temperature>, val name: List<City>)
//
//class City(val name: String)
//
//class Temperature(val temp: Int)