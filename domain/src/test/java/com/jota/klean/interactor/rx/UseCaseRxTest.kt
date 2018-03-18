package com.jota.klean.interactor.rx

import com.jota.klean.domain.executor.PostExecutionThread
import com.jota.klean.domain.executor.ThreadExecutor
import com.jota.klean.domain.interactor.rx.UseCaseRx
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.TestScheduler
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Jota Ramirez on 18/3/18.
 */
@RunWith(MockitoJUnitRunner::class)
class UseCaseRxTest {

    private lateinit var useCase: UseCaseTestClass
    private lateinit var testObserver: TestDisposableObserver<Any>

    @Mock
    private lateinit var mockThreadExecutor: ThreadExecutor
    @Mock
    private lateinit var mockPostExecutionThread: PostExecutionThread

    @Rule
    @JvmField
    var expectedException = ExpectedException.none()

    @Before
    fun setUp() {
        this.useCase = UseCaseTestClass(mockThreadExecutor, mockPostExecutionThread)
        this.testObserver = TestDisposableObserver()
        given<Scheduler>(mockPostExecutionThread.getScheduler()).willReturn(TestScheduler())
    }

    @Test
    fun testBuildUseCaseObservableReturnCorrectResult() {
        useCase.execute(testObserver, Params.EMPTY)

        assertThat(testObserver.valuesCount).isZero()
    }

    @Test
    fun testSubscriptionWhenExecutingUseCase() {
        useCase.execute(testObserver, Params.EMPTY)
        useCase.dispose()

        assertThat(testObserver.isDisposed).isTrue()
    }

    @Test
    fun testShouldFailWhenExecuteWithNullObserver() {
        expectedException.expect(NullPointerException::class.java)
        useCase.execute(null, Params.EMPTY)
    }

    private class UseCaseTestClass internal constructor(
            threadExecutor: ThreadExecutor,
            postExecutionThread: PostExecutionThread
    ) : UseCaseRx<Any, Params>(threadExecutor, postExecutionThread) {

        override fun buildUseCaseObservable(params: Params): Observable<Any> {
            return Observable.empty()
        }
    }

    private class TestDisposableObserver<T> : DisposableObserver<T>() {
        var valuesCount = 0

        override fun onNext(value: T) {
            valuesCount++
        }

        override fun onError(e: Throwable) {
            // no-op by default.
        }

        override fun onComplete() {
            // no-op by default.
        }
    }

    class Params {

        companion object {
            val EMPTY: Params = Params()
        }
    }
}