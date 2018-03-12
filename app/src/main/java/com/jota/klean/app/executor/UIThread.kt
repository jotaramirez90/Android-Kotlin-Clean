package com.jota.klean.app.executor

import com.jota.klean.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by jotaramirez on 12/3/18.
 */
class UIThread @Inject constructor() : PostExecutionThread {
    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}