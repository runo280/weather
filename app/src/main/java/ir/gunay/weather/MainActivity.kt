package ir.gunay.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.gunay.weather.ui.setting.SettingFragment
import ir.gunay.weather.ui.weather.WeatherFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, WeatherFragment.newInstance())
                .commitNow()
        }


    }
}
