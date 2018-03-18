package com.jota.klean.ui.features.main

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import com.jota.klean.R
import com.jota.klean.ui.common.FragmentTestRule
import com.jota.klean.ui.features.main.rx.RxMainFragment
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations

/**
 * Created by Jota Ramirez on 18/3/18.
 */
@RunWith(AndroidJUnit4::class)
class RxMainFragmentTest {

    @get:Rule
    val testRule: FragmentTestRule<RxMainFragment> = FragmentTestRule(RxMainFragment::class.java)

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testOnCreate() {
        testRule.launchActivity(null)
        onView(withId(R.id.tv_text)).check(matches(isDisplayed()))
    }
}