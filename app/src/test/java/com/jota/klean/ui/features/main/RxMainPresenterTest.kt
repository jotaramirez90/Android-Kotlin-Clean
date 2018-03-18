package com.jota.klean.ui.features.main

import com.jota.klean.domain.interactor.rx.GetWeatherRx
import com.jota.klean.model.mapper.CityWeatherViewModelMapper
import com.jota.klean.ui.features.main.rx.RxMainPresenter
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.`when` as whenever

/**
 * Created by Jota Ramirez on 18/3/18.
 */
@RunWith(MockitoJUnitRunner::class)
class RxMainPresenterTest {

    @Mock
    lateinit var mockGetWeatherRx: GetWeatherRx
    @Mock
    lateinit var mockCityWeatherViewModelMapper: CityWeatherViewModelMapper
    lateinit var presenter: RxMainPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = RxMainPresenter(mockGetWeatherRx, mockCityWeatherViewModelMapper)
    }

    @Test
    fun testCreate() {
        assertNotNull(presenter)
    }
}