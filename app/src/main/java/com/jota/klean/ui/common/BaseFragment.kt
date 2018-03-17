package com.jota.klean.ui.common

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jota.klean.app.extensions.app
import com.jota.klean.app.internal.di.components.ViewComponent
import javax.inject.Inject

/**
 * Created by jotaramirez on 8/3/18.
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<in V : IView, T : IPresenter<V>, out C : ViewComponent<V>> : Fragment() {

    @Inject
    lateinit var mPresenter: T

    protected val appComponent by lazy(mode = LazyThreadSafetyMode.NONE) { activity.app.mAppComponent }

    abstract fun bindComponent(): C

    abstract fun bindLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindComponent().inject(this as V)
        mPresenter.create()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater?.inflate(bindLayout(), container, false)

    override fun onViewCreated(view: android.view.View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.attachView(this as V)
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
}