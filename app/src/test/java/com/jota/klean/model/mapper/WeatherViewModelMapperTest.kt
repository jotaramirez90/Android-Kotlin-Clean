package com.jota.klean.model.mapper

import com.jota.klean.domain.model.Weather
import com.jota.klean.model.WeatherViewModel
import junit.framework.TestCase
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Assert.assertThat
import org.junit.Test
import org.mockito.Mockito.mock

/**
 * Created by Jota Ramirez on 18/3/18.
 */
class WeatherViewModelMapperTest : TestCase() {

    private lateinit var mapper: WeatherViewModelMapper

    override fun setUp() {
        super.setUp()
        mapper = WeatherViewModelMapper()
    }

    @Test
    fun testTransformWeather() {
        val weather = createFakeWeather()
        val weatherViewModel = mapper.transform(weather)

        assertThat(weatherViewModel, `is`(instanceOf(WeatherViewModel::class.java)))
        assertThat(weatherViewModel.id, `is`("id"))
        assertThat(weatherViewModel.main, `is`("main"))
        assertThat(weatherViewModel.description, `is`("description"))
        assertThat(weatherViewModel.icon, `is`("icon"))
    }

    @Test
    fun testTransformWeatherCollection() {
        val listWeather: List<Weather> =
                arrayListOf<Weather>(mock(Weather::class.java), mock(Weather::class.java))
        val list = mapper.transform(listWeather)

        assertThat(list[0], `is`(instanceOf(WeatherViewModel::class.java)))
        assertThat(list[1], `is`(instanceOf(WeatherViewModel::class.java)))
        assertThat(list.size, `is`(2))
    }

    private fun createFakeWeather() = Weather(
            "id",
            "main",
            "description",
            "icon"
    )
}