package com.jota.klean.ui.common

import android.app.ActionBar
import android.app.Fragment
import android.app.FragmentTransaction
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.jota.klean.app.extensions.app
import com.jota.klean.app.internal.di.components.ViewComponent
import javax.inject.Inject

/**
 * Created by jotaramirez on 5/3/18.
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<in V : IView, T : IPresenter<V>, out C : ViewComponent<V>> : AppCompatActivity() {

    @Inject
    lateinit var mPresenter: T

    val mAppComponent by lazy(mode = LazyThreadSafetyMode.NONE) { app.mAppComponent }

    val mNavigator by lazy(mode = LazyThreadSafetyMode.NONE) { app.mNavigator }

    abstract fun bindComponent(): C

    abstract fun bindLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindComponent().inject(this as V)
        mPresenter.attachView(this as V)
        mPresenter.create()
        setContentView(layoutInflater.inflate(bindLayout(), null))
        mPresenter.viewPrepared()
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (android.R.id.home == item.itemId) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    protected fun replaceFragment(containerViewId: Int, fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(containerViewId, fragment)
        fragmentTransaction.commit()
    }

    protected fun addFragment(containerViewId: Int, fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(containerViewId, fragment)
        fragmentTransaction.commit()
    }

    protected fun enableHomeAsUp() {
        val actionBar: ActionBar? = actionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeButtonEnabled(true)
    }

    protected fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}