package ir.gunay.weather.utils

import android.widget.ImageView
import coil.api.load

fun loadImage(icon: String, imageView: ImageView) {
    imageView.load("https://openweathermap.org/img/wn/${icon}@2x.png") {
//        crossfade(true)
    }
}