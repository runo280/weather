package ir.gunay.weather.data

import ir.gunay.weather.data.response.CurrentWeather

interface Repository {
    suspend fun getCurrentWeather(): CurrentWeather
    suspend fun getForecast()
}