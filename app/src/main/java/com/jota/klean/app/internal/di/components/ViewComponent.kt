package com.jota.klean.app.internal.di.components

import com.jota.klean.app.base.IView

/**
 * Created by jotaramirez on 8/3/18.
 */
interface ViewComponent<in T : IView> {

    fun inject(view: T)
}