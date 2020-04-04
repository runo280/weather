package ir.gunay.weather.ui.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ir.gunay.weather.data.NetworkRepository
import kotlinx.coroutines.Dispatchers

class WeatherViewModel : ViewModel() {

    private val repository: NetworkRepository = NetworkRepository()
    val current = liveData(Dispatchers.IO) {
        val current = repository.getCurrentWeather()
        emit(current)
    }

}