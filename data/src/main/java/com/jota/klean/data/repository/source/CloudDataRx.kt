package com.jota.klean.data.repository.source

import com.jota.klean.data.entity.CityWeatherEntity
import io.reactivex.Observable

/**
 * Created by jotaramirez on 11/3/18.
 */
interface CloudDataRx {

    fun getCityWeather(latitude: String, longitude: String): Observable<CityWeatherEntity>
}