package com.jota.klean.app.di.components.main

import com.jota.klean.app.di.scope.PerView
import com.jota.klean.app.di.components.ViewComponent
import com.jota.klean.app.di.modules.main.MainModule
import com.jota.klean.ui.features.main.MainActivity
import dagger.Subcomponent

/**
 * Created by jotaramirez on 8/3/18.
 */
@PerView
@Subcomponent(modules = [(MainModule::class)])
interface MainComponent : ViewComponent<MainActivity> {

    override fun inject(view: MainActivity)
}