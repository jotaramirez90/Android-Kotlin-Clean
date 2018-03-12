package com.jota.klean.data.executor

import com.jota.klean.domain.executor.ThreadExecutor
import java.util.concurrent.*
import java.util.concurrent.TimeUnit.SECONDS
import javax.inject.Inject

/**
 * Created by jotaramirez on 12/3/18.
 */
class JobExecutor @Inject constructor() : ThreadExecutor {

    private val INITIAL_POOL_SIZE: Int = 3
    private val MAX_POOL_SIZE: Int = 5
    private val KEEP_ALIVE_TIME: Long = 10
    private val KEEP_ALIVE_TIME_UNIT: TimeUnit = SECONDS

    private val workQueue: BlockingQueue<Runnable> = LinkedBlockingQueue()
    private val threadFactory: ThreadFactory = JobThreadFactory
    private val threadPoolExecutor: ThreadPoolExecutor = ThreadPoolExecutor(
            INITIAL_POOL_SIZE,
            MAX_POOL_SIZE,
            KEEP_ALIVE_TIME,
            KEEP_ALIVE_TIME_UNIT,
            this.workQueue,
            this.threadFactory
    )

    override fun execute(runnable: Runnable?) {
        this.threadPoolExecutor.execute(runnable)
    }

    private object JobThreadFactory : ThreadFactory {
        private val THREAD_NAME: String = "android_"
        private var counter: Int = 0

        override fun newThread(runnable: Runnable?): Thread {
            return Thread(
                    runnable,
                    THREAD_NAME + counter++
            )
        }
    }
}