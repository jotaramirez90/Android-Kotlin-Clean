package com.jota.klean.data.entity.mapper

import com.jota.klean.data.entity.CityWeatherEntity
import com.jota.klean.domain.model.CityWeather
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by jotaramirez on 12/3/18.
 */
@Singleton
class CityWeatherEntityDataMapper @Inject constructor() {

    fun transform(entity: CityWeatherEntity): CityWeather {
        return CityWeather(
                entity.base,
                entity.visibility,
                entity.dt,
                entity.id,
                entity.name,
                entity.cod)
    }
}