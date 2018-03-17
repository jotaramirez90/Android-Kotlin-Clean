package com.jota.klean.ui.features.main.rx

import com.jota.klean.R
import com.jota.klean.app.di.components.main.rx.RxMainComponent
import com.jota.klean.app.di.modules.main.rx.RxMainModule
import com.jota.klean.model.CityWeatherViewModel
import com.jota.klean.ui.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_coroutines_main.*

/**
 * Created by Jota Ramirez on 16/3/18.
 */
class RxMainFragment
    : BaseFragment<RxMainFragment, RxMainPresenter, RxMainComponent>(), RxMainView {

    companion object {

        fun newInstance() = RxMainFragment()
    }

    override fun bindComponent(): RxMainComponent = appComponent.plus(RxMainModule())

    override fun bindLayout(): Int = R.layout.fragment_rx_main

    override fun setData(data: CityWeatherViewModel) {
        tv_text.text = data.name
    }

    override fun setError(error: String) {
        tv_text.text = error
    }
}