package com.jota.klean.interactor.rx

import com.jota.klean.domain.executor.PostExecutionThread
import com.jota.klean.domain.executor.ThreadExecutor
import com.jota.klean.domain.interactor.rx.GetWeatherRx
import com.jota.klean.repository.TestRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner


/**
 * Created by Jota Ramirez on 18/3/18.
 */
@RunWith(MockitoJUnitRunner::class)
class GetWeatherRxTest {

    private lateinit var getWeatherRx: GetWeatherRx

    @Mock
    private lateinit var mockThreadExecutor: ThreadExecutor
    @Mock
    private lateinit var mockPostExecutionThread: PostExecutionThread
    @Mock
    private lateinit var mockUserRepository: TestRepository

    @Before
    fun setUp() {
        getWeatherRx = GetWeatherRx(mockUserRepository, mockThreadExecutor,
                mockPostExecutionThread)
    }

    @Test
    fun testGetWeatherCaseObservableHappyCase() {
        val params = GetWeatherRx.Params.forCity("", "")
        getWeatherRx.buildUseCaseObservable(params)

        verify(mockUserRepository).getCityWeatherRx(params.latitude, params.longitude)
        verifyNoMoreInteractions(mockUserRepository)
        verifyZeroInteractions(mockThreadExecutor)
        verifyZeroInteractions(mockPostExecutionThread)
    }
}