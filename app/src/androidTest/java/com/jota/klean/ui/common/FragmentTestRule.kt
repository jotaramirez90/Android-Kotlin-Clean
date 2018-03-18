package com.jota.klean.ui.common

import android.app.Fragment
import android.support.test.rule.ActivityTestRule
import com.jota.klean.R
import org.junit.Assert


/**
 * Created by Jota Ramirez on 18/3/18.
 */
class FragmentTestRule<F : Fragment>(private val mFragmentClass: Class<F>)
    : ActivityTestRule<TestActivity>(TestActivity::class.java, true, false) {

    lateinit var fragment: F
        private set

    override fun afterActivityLaunched() {
        super.afterActivityLaunched()

        activity.runOnUiThread({
            try {
                val manager = activity.fragmentManager
                val transaction = manager.beginTransaction()
                fragment = mFragmentClass.newInstance()
                transaction.replace(R.id.container, fragment)
                transaction.commit()
            } catch (e: InstantiationException) {
                Assert.fail(String.format(
                        "%s: Could not insert %s into TestActivity: %s",
                        javaClass.simpleName,
                        mFragmentClass.simpleName,
                        e.message
                ))
            } catch (e: IllegalAccessException) {
                Assert.fail(String.format(
                        "%s: Could not insert %s into TestActivity: %s",
                        javaClass.simpleName,
                        mFragmentClass.simpleName,
                        e.message
                ))
            }
        })
    }
}