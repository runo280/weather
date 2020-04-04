package ir.gunay.weather.data

import ir.gunay.weather.data.response.CurrentWeather

class RepositoryImp : Repository {
    override suspend fun getCurrentWeather(): CurrentWeather {
        TODO("Not yet implemented")
    }

    override suspend fun getForecast() {
        TODO("Not yet implemented")
    }

}