package com.jota.klean.data.net.rx

import com.jota.klean.data.entity.CityWeatherEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by jotaramirez on 12/3/18.
 */
interface ApiRx {

    @GET("weather")
    fun getCityWeather(
            @Query("lat") latitude: String,
            @Query("lon") longitude: String,
            @Query("units") units: String,
            @Query("APPID") appId: String
    ): Observable<CityWeatherEntity>
}