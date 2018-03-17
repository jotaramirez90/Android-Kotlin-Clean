package com.jota.klean.model

import com.jota.klean.domain.model.Weather

/**
 * Created by Jota Ramirez on 17/3/18.
 */
data class CityWeatherViewModel(
        var weather: List<WeatherViewModel>?,
        var base: String?,
        var visibility: Int?,
        var dt: Int?,
        var id: Int?,
        var name: String?,
        var cod: Int?
)