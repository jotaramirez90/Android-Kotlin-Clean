package com.jota.klean.app.internal.di.components.main.rx

import com.jota.klean.app.internal.di.scope.PerView
import com.jota.klean.app.internal.di.components.ViewComponent
import com.jota.klean.app.internal.di.modules.main.rx.RxMainModule
import com.jota.klean.ui.features.main.rx.RxMainFragment
import dagger.Subcomponent

/**
 * Created by Jota Ramirez on 16/3/18.
 */
@PerView
@Subcomponent(modules = [(RxMainModule::class)])
interface RxMainComponent : ViewComponent<RxMainFragment> {

    override fun inject(view: RxMainFragment)
}