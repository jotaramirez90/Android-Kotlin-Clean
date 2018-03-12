package com.jota.klean.data.repository.source

import com.jota.klean.data.BuildConfig
import com.jota.klean.data.entity.CityWeatherEntity
import com.jota.klean.data.net.rx.ApiRx
import io.reactivex.Observable

/**
 * Created by jotaramirez on 11/3/18.
 */
class CloudDataRxStore(private val apiRx: ApiRx) : CloudDataRx {

    override fun getCityWeather(latitude: String, longitude: String): Observable<CityWeatherEntity> =
            apiRx.getCityWeather(latitude, longitude, "metric", BuildConfig.APPID)
}