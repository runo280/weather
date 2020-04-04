package ir.gunay.weather.data.api

import ir.gunay.weather.data.response.CurrentWeather
import ir.gunay.weather.data.response.Forecast
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("data/2.5/weather")
    suspend fun byCoordinate(
        @Query("lat") lat: String,
        @Query("lon") lon: String
    ): CurrentWeather.Weather

    @GET("data/2.5/weather")
    suspend fun byCity(
        @Query("q") city: String
    ): CurrentWeather

    @GET("data/2.5/forecast")
    suspend fun forecastByCity(
        @Query("q") city: String
    ) : Forecast
}