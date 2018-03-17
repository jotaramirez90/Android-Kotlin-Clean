package com.jota.klean.app.di.components.details

import com.jota.klean.app.di.scope.PerView
import com.jota.klean.app.di.components.ViewComponent
import com.jota.klean.app.di.modules.details.DetailsModule
import com.jota.klean.ui.features.details.DetailsActivity
import dagger.Subcomponent

/**
 * Created by Jota Ramirez on 13/3/18.
 */
@PerView
@Subcomponent(modules = [(DetailsModule::class)])
interface DetailsComponent : ViewComponent<DetailsActivity> {
}