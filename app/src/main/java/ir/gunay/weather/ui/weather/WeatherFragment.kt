package ir.gunay.weather.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import ir.gunay.weather.R
import ir.gunay.weather.utils.loadImage
import kotlinx.android.synthetic.main.weather_fragment.*

class WeatherFragment : Fragment() {

    companion object {
        fun newInstance() = WeatherFragment()
    }

    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.weather_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.current.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, "observe", Toast.LENGTH_SHORT).show()
            it?.let { weather ->
                tvTemp.text = weather.main.temp.toString()
                tvDate.text = weather.weather[0].description
                loadImage(weather.weather[0].icon,imgWeatherIcon)
            }
        })
    }

}
