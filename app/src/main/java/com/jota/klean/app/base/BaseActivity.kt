package com.jota.klean.app.base

import android.app.ActionBar
import android.app.Fragment
import android.app.FragmentTransaction
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast

/**
 * Created by jotaramirez on 5/3/18.
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<in V : IView, out T : Presenter<V>> : AppCompatActivity() {

    private lateinit var mPresenter: T

    abstract fun bindLayout(): Int

    abstract fun bindPresenter(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        onBeforeCreated()
        super.onCreate(savedInstanceState)
        initializeActivity()
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (android.R.id.home == item.itemId) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    open fun onBeforeCreated() {}

    open fun onAfterCreated() {
        mPresenter.viewPrepared()
    }

    open fun initializeActivity() {
        mPresenter = bindPresenter()
        mPresenter.attachView(this as V)
        mPresenter.create()
        setContentView(layoutInflater.inflate(bindLayout(), null))
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