package com.jota.klean.ui.features.main.fragment

import com.jota.klean.R
import com.jota.klean.app.internal.di.components.main.fragment.MainFragmentComponent
import com.jota.klean.app.internal.di.modules.main.fragment.MainFragmentModule
import com.jota.klean.ui.common.BaseFragment

/**
 * Created by Jota Ramirez on 16/3/18.
 */
class MainFragment : BaseFragment<MainFragment, MainFragmentPresenter, MainFragmentComponent>(), MainFragmentView {

    companion object {

        fun newInstance() = MainFragment()
    }

    override fun bindComponent(): MainFragmentComponent = appComponent.plus(MainFragmentModule())

    override fun bindLayout(): Int = R.layout.fragment_main
}