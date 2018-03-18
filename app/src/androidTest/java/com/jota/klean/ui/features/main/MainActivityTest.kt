package com.jota.klean.ui.features.main

import android.support.design.widget.BottomNavigationView
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.jota.klean.App
import com.jota.klean.R
import com.jota.klean.app.di.ApplicationComponentTest
import com.jota.klean.app.di.DaggerApplicationComponentTest
import com.jota.klean.app.di.modules.ApplicationModule
import junit.framework.Assert
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Created by Jota Ramirez on 17/3/18.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val testRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    private lateinit var testAppComponent: ApplicationComponentTest

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        val app = InstrumentationRegistry.getTargetContext().applicationContext as App
        testAppComponent = DaggerApplicationComponentTest.builder()
                .applicationModule(ApplicationModule(app))
                .build()
        testAppComponent.inject(this)
    }

    @Test
    fun testOnCreate() {
        val activity = testRule.activity
        Assert.assertNotNull(activity.mPresenter)
        Assert.assertNotNull(activity.container)
        Assert.assertNotNull(activity.navigation)
        Assert.assertEquals(activity.supportActionBar?.title, activity.getString(R.string.main_title))

        onView(withId(R.id.container)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation)).check(matches(isDisplayed()))
    }

    @Test
    fun testBottomNavigation() {
        val listener = mock(BottomNavigationView.OnNavigationItemSelectedListener::class.java)
        val bottomNavigation = testRule.activity.navigation
        bottomNavigation.setOnNavigationItemSelectedListener(listener)

        bottomNavigation.selectedItemId = R.id.navigation_rx
        verify(listener, times(1))
                .onNavigationItemSelected(bottomNavigation.menu.findItem(R.id.navigation_rx))
        assertTrue(bottomNavigation.menu.findItem(R.id.navigation_rx).isChecked)
        verifyNoMoreInteractions(listener)
    }
}