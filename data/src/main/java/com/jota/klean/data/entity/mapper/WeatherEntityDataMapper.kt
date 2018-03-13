package com.jota.klean.data.entity.mapper

import com.jota.klean.data.entity.WeatherEntity
import com.jota.klean.domain.model.Weather
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Jota Ramirez on 13/3/18.
 */
@Singleton
class WeatherEntityDataMapper @Inject constructor() {

    fun transform(entity: WeatherEntity): Weather =
            Weather(
                    entity.id,
                    entity.main,
                    entity.description,
                    entity.icon
            )

    fun transform(entities: List<WeatherEntity>?): List<Weather> =
            entities?.map { transform(it) } ?: arrayListOf()
}