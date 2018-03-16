package com.jota.klean.app.internal.di.components.main.fragment

import com.jota.klean.app.internal.di.annotation.PerView
import com.jota.klean.app.internal.di.components.ViewComponent
import com.jota.klean.app.internal.di.modules.main.fragment.MainFragmentModule
import com.jota.klean.ui.features.main.fragment.MainFragment
import dagger.Subcomponent

/**
 * Created by Jota Ramirez on 16/3/18.
 */
@PerView
@Subcomponent(modules = [(MainFragmentModule::class)])
interface MainFragmentComponent : ViewComponent<MainFragment> {

    override fun inject(view: MainFragment)
}