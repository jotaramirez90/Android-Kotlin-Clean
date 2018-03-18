package com.jota.klean.interactor.coroutines

import com.jota.klean.domain.interactor.coroutines.GetWeatherCoroutines
import com.jota.klean.repository.TestRepository
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Jota Ramirez on 18/3/18.
 */
@RunWith(MockitoJUnitRunner::class)
class GetWeatherCoroutinesTest {

    private lateinit var getWeatherCoroutines: GetWeatherCoroutines

    @Mock
    private lateinit var mockUserRepository: TestRepository

    @Before
    fun setUp() {
        getWeatherCoroutines = GetWeatherCoroutines(mockUserRepository)
    }

    @Test
    fun testGetWeatherCaseCoroutinesHappyCase() {
        val params = GetWeatherCoroutines.Params.forCity("", "")
        getWeatherCoroutines.buildUseCaseObservable(params)

        val actualRepos = runBlocking {
            verify(mockUserRepository).getCityWeatherCoroutines("", "")
            verifyNoMoreInteractions(mockUserRepository)
        }
    }
}