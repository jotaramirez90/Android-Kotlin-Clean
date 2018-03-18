package com.jota.klean.data.repository

import com.jota.klean.data.entity.CityWeatherEntity
import com.jota.klean.data.entity.mapper.CityWeatherEntityDataMapper
import com.jota.klean.data.repository.source.CloudDataCoroutines
import com.jota.klean.data.repository.source.CloudDataRx
import com.jota.klean.data.repository.source.DataStoreFactory
import io.reactivex.Observable
import kotlinx.coroutines.experimental.CompletableDeferred
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


/**
 * Created by Jota Ramirez on 18/3/18.
 */
@RunWith(MockitoJUnitRunner.Silent::class)
class DataRepositoryTest {

    private lateinit var dataRepository: DataRepository

    @Mock
    private lateinit var mockDataStoreFactory: DataStoreFactory
    @Mock
    private lateinit var mockCityWeatherEntityDataMapper: CityWeatherEntityDataMapper
    @Mock
    private lateinit var mockCloudDataRx: CloudDataRx
    @Mock
    private lateinit var mockCloudDataCoroutines: CloudDataCoroutines

    @Before
    fun setUp() {
        dataRepository = DataRepository(mockDataStoreFactory, mockCityWeatherEntityDataMapper)
        given(mockDataStoreFactory.createCloudDataRx()).willReturn(mockCloudDataRx)
        given(mockDataStoreFactory.createCloudDataCoroutines()).willReturn(mockCloudDataCoroutines)
    }

    @Test
    fun testGetCityWeatherRxHappyCase() {
        val data = CityWeatherEntity(arrayListOf(), "", 0, 0, 0, "", 0)
        given(mockCloudDataRx.getCityWeather("", "")).willReturn(Observable.just(data))

        dataRepository.getCityWeatherRx("", "")

        verify(mockDataStoreFactory).createCloudDataRx()
        verify(mockCloudDataRx).getCityWeather("", "")
    }

    @Test
    fun testGetCityWeatherCoroutinesHappyCase() {
        val data = CityWeatherEntity(arrayListOf(), "", 0, 0, 0, "", 0)
        runBlocking {
            given(mockCloudDataCoroutines.getCityWeather("", ""))
                    .willReturn(CompletableDeferred(data))
        }

        dataRepository.getCityWeatherCoroutines("", "")

        verify(mockDataStoreFactory).createCloudDataCoroutines()
        runBlocking {
            verify(mockCloudDataCoroutines).getCityWeather("", "")
        }
    }
}