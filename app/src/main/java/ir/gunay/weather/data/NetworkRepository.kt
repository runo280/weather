package ir.gunay.weather.data

import ir.gunay.weather.API_KEY
import ir.gunay.weather.BuildConfig
import ir.gunay.weather.ENDPOINT
import ir.gunay.weather.data.api.WeatherAPI
import ir.gunay.weather.data.response.CurrentWeather
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class NetworkRepository : Repository {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl(ENDPOINT)
            client(getClient(getApiKeyInterceptor()))
            addConverterFactory(MoshiConverterFactory.create())
        }.build()
    }

    private fun getClient(apiKeyInterceptor: Interceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(apiKeyInterceptor)
        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        return okHttpClient.build()
    }

    private fun getApiKeyInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
            val url = request.url
            val newUrl = url.newBuilder()
                .addQueryParameter("appid", API_KEY).build()
            val requestBuilder = request.newBuilder().url(newUrl)
            val newRequest = requestBuilder.build()
            chain.proceed(newRequest)
        }
    }

    override suspend fun getCurrentWeather(): CurrentWeather {
        return getRetrofit().create(WeatherAPI::class.java).byCity("urmia")
    }

    override suspend fun getForecast() {
        TODO("Not yet implemented")
    }

}