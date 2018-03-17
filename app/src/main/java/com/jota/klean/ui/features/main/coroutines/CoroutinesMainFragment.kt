package com.jota.klean.ui.features.main.coroutines

import com.jota.klean.R
import com.jota.klean.app.di.components.main.coroutines.CoroutinesMainComponent
import com.jota.klean.app.di.modules.main.coroutines.CoroutinesMainModule
import com.jota.klean.model.CityWeatherViewModel
import com.jota.klean.ui.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_coroutines_main.*

/**
 * Created by Jota Ramirez on 17/3/18.
 */
class CoroutinesMainFragment
    : BaseFragment<CoroutinesMainFragment, CoroutinesMainPresenter, CoroutinesMainComponent>(),
        CoroutinesMainView {

    companion object {

        fun newInstance() = CoroutinesMainFragment()
    }

    override fun bindComponent(): CoroutinesMainComponent = appComponent.plus(CoroutinesMainModule())

    override fun bindLayout(): Int = R.layout.fragment_coroutines_main

    override fun setData(data: CityWeatherViewModel) {
        tv_text.text = data.name
    }

    override fun setError(error: String) {
        tv_text.text = error
    }
}