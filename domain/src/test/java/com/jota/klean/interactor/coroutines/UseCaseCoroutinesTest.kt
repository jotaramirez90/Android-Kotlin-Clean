package com.jota.klean.interactor.coroutines

import com.jota.klean.domain.interactor.coroutines.ResultCoroutines
import com.jota.klean.domain.interactor.coroutines.UseCaseCoroutines
import kotlinx.coroutines.experimental.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.core.IsInstanceOf
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Jota Ramirez on 18/3/18.
 */
@RunWith(MockitoJUnitRunner::class)
class UseCaseCoroutinesTest {

    private lateinit var useCase: UseCaseTestClass

    @Rule
    @JvmField
    var expectedException = ExpectedException.none()

    @Before
    fun setUp() {
        this.useCase = UseCaseTestClass()
    }

    @Test
    fun testBuildUseCaseObservableReturnCorrectResult() {
        val result = runBlocking {
            useCase.execute(Params.EMPTY)
        }
        assertThat(result, `is`(IsInstanceOf(ResultCoroutines::class.java)))
    }

    private class UseCaseTestClass internal constructor() : UseCaseCoroutines<Any, Params>() {

        override fun buildUseCaseObservable(params: Params): ResultCoroutines<Any> {
            return ResultCoroutines.Success("")
        }
    }

    class Params {

        companion object {
            val EMPTY: Params = Params()
        }
    }
}