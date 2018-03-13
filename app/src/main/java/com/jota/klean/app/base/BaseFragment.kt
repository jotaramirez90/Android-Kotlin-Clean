package com.jota.klean.app.base

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jota.klean.app.internal.di.components.ViewComponent
import javax.inject.Inject

/**
 * Created by jotaramirez on 8/3/18.
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<in V : IView, T : Presenter<V>, out C : ViewComponent<V>> : Fragment() {

    @Inject
    lateinit var mPresenter: T

    abstract fun bindViewComponent(): C

    abstract fun bindLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): android.view.View? =
            inflater?.inflate(bindLayout(), container, false)

    override fun onViewCreated(view: android.view.View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.attachView(this as V)
        onAfterCreated()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.resume()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.destroy()
    }

    open fun onAfterCreated() {
    }

    open fun initializeFragment() {
        bindViewComponent().inject(this as V)
        mPresenter.create()
    }
}