package com.jota.klean.domain.model

/**
 * Created by jotaramirez on 11/3/18.
 */
data class CityWeather(
        var weather: List<Weather>?,
        var base: String?,
        var visibility: Int?,
        var dt: Int?,
        var id: Int?,
        var name: String?,
        var cod: Int?
)