package com.jota.klean.data.entity

/**
 * Created by jotaramirez on 11/3/18.
 */
data class CityWeatherEntity(
        var weather: List<WeatherEntity>?,
        var base: String?,
        var visibility: Int?,
        var dt: Int?,
        var id: Int?,
        var name: String?,
        var cod: Int?
)