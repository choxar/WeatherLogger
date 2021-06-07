
package com.example.weatherlogger


import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("wind")
fun bindWind(textView: TextView, windSpeed: Double?){
    textView.text=  windSpeed.toString() + " m/s"
}
@BindingAdapter("city")
fun bindCity(textView: TextView, cityName: String?){
    textView.text= "${cityName}"
}
@BindingAdapter("country")
fun bindCountry(textView: TextView, countryName: String?){
    textView.text= "Country: ${countryName}"
}
@BindingAdapter("description")
fun bindDescription(textView: TextView, description: String?){
    textView.text= "${description}"
}
@BindingAdapter("temp")
fun bindTemp(textView: TextView, temp: Double?){
    textView.text= "${temp.toString()} °C"
}
@BindingAdapter("min")
fun bindMin(textView: TextView, temp: Double?){
    textView.text= "${temp.toString()} °C"
}
@BindingAdapter("max")
fun bindMax(textView: TextView, temp: Double?){
    textView.text= "${temp.toString()} °C"
}
@BindingAdapter("feels")
fun bindFeels(textView: TextView, temp: Double?){
    textView.text= "${temp.toString()} °C"
}
@BindingAdapter("visibility")
fun bindVisibility(textView: TextView, temp: Int?){
    textView.text= "Visibility: ${temp.toString()}"
}
@BindingAdapter("pressure")
fun bindPressure(textView: TextView, temp: Int?){
    textView.text= "${temp.toString()}"
}



