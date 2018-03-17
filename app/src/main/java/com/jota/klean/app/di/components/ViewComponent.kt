package com.jota.klean.app.di.components

import com.jota.klean.ui.common.IView

/**
 * Created by jotaramirez on 8/3/18.
 */
interface ViewComponent<in T : IView> {

    fun inject(view: T)
}