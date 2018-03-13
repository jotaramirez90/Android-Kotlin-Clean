package com.jota.klean.data.net.coroutines

import com.jota.klean.data.entity.CityWeatherEntity
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by jotaramirez on 11/3/18.
 */
interface ApiCoroutines {

    @GET("weather")
    fun getCityWeather(
            @Query("lat") latitude: String,
            @Query("lon") longitude: String,
            @Query("units") units: String,
            @Query("APPID") appId: String
    ): Deferred<CityWeatherEntity?>
}