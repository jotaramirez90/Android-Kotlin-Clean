package com.jota.klean.ui.features.main.rx

import com.jota.klean.R
import com.jota.klean.app.internal.di.components.main.rx.RxMainComponent
import com.jota.klean.app.internal.di.modules.main.rx.RxMainModule
import com.jota.klean.ui.common.BaseFragment

/**
 * Created by Jota Ramirez on 16/3/18.
 */
class RxMainFragment : BaseFragment<RxMainFragment, RxMainPresenter, RxMainComponent>(), RxMainView {

    companion object {

        fun newInstance() = RxMainFragment()
    }

    override fun bindComponent(): RxMainComponent = appComponent.plus(RxMainModule())

    override fun bindLayout(): Int = R.layout.fragment_main
}