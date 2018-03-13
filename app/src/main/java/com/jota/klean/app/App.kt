package com.jota.klean.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.jota.klean.app.internal.di.components.ApplicationComponent
import com.jota.klean.app.internal.di.components.DaggerApplicationComponent
import com.jota.klean.app.internal.di.modules.ApplicationModule
import com.jota.klean.app.navigator.Navigator
import javax.inject.Inject

/**
 * Created by jotaramirez on 8/3/18.
 */
class App : Application(), Application.ActivityLifecycleCallbacks {

    @Inject lateinit var mNavigator: Navigator

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
        registerActivityLifecycleCallbacks(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        unregisterActivityLifecycleCallbacks(this)
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
    }

    override fun onActivityStarted(activity: Activity?) {
    }

    override fun onActivityResumed(activity: Activity?) {
        mNavigator.setActivity(activity)
    }

    override fun onActivityPaused(activity: Activity?) {
        mNavigator.setActivity(null)
    }

    override fun onActivityStopped(activity: Activity?) {
    }

    override fun onActivityDestroyed(activity: Activity?) {
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }
}