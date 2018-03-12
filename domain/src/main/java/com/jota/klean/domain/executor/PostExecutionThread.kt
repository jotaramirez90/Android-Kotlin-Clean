package com.jota.klean.domain.executor

import io.reactivex.Scheduler

/**
 * Created by jotaramirez on 12/3/18.
 */
interface PostExecutionThread {
    fun getScheduler(): Scheduler
}