package com.jota.klean.app.di.components.main.coroutines

import com.jota.klean.app.di.components.ViewComponent
import com.jota.klean.app.di.modules.main.coroutines.CoroutinesMainModule
import com.jota.klean.app.di.scope.PerView
import com.jota.klean.ui.features.main.coroutines.CoroutinesMainFragment
import dagger.Subcomponent

/**
 * Created by Jota Ramirez on 17/3/18.
 */
@PerView
@Subcomponent(modules = arrayOf(CoroutinesMainModule::class))
interface CoroutinesMainComponent : ViewComponent<CoroutinesMainFragment> {

    override fun inject(view: CoroutinesMainFragment)
}