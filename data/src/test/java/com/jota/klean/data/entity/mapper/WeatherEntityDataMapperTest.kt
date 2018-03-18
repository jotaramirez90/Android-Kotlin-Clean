package com.jota.klean.data.entity.mapper

import com.jota.klean.data.entity.WeatherEntity
import com.jota.klean.domain.model.Weather
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Jota Ramirez on 18/3/18.
 */
@RunWith(MockitoJUnitRunner::class)
class WeatherEntityDataMapperTest {

    private lateinit var mapper: WeatherEntityDataMapper

    @Before
    fun setUp() {
        mapper = WeatherEntityDataMapper()
    }

    @Test
    fun testTransformWeatherEntity() {
        val weatherEntity = createFakeWeather()
        val weather = mapper.transform(weatherEntity)

        assertThat(weather, `is`(instanceOf(Weather::class.java)))
        assertThat(weather.id, `is`("id"))
        assertThat(weather.main, `is`("main"))
        assertThat(weather.description, `is`("description"))
        assertThat(weather.icon, `is`("icon"))
    }

    @Test
    fun testTransformWeatherCollection() {
        val listWeather: List<WeatherEntity> =
                arrayListOf<WeatherEntity>(mock(WeatherEntity::class.java), mock(WeatherEntity::class.java))
        val list = mapper.transform(listWeather)

        assertThat(list[0], `is`(instanceOf(Weather::class.java)))
        assertThat(list[1], `is`(instanceOf(Weather::class.java)))
        assertThat(list.size, `is`(2))
    }

    private fun createFakeWeather() = WeatherEntity(
            "id",
            "main",
            "description",
            "icon"
    )
}