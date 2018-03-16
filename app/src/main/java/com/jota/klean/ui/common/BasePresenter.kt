package com.jota.klean.ui.common

import kotlinx.coroutines.experimental.Job

/**
 * Created by jotaramirez on 5/3/18.
 */
open class BasePresenter<V : IView> : IPresenter<V> {

    protected var view: V? = null
    protected var mJobs: MutableList<Job?> = mutableListOf()

    override fun attachView(view: V) {
        this.view = view
    }

    override fun create() {
    }

    override fun viewPrepared() {
    }

    override fun resume() {
    }

    override fun pause() {
    }

    override fun destroy() {
        for (job in mJobs) {
            job?.cancel()
        }
    }
}