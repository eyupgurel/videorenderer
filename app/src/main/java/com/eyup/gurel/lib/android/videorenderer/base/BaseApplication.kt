package com.eyup.gurel.lib.android.videorenderer.base

import android.app.Application
import com.eyup.gurel.lib.android.videorenderer.BuildConfig
import com.eyup.gurel.lib.dagger2.di.ActivityInjector
import com.eyup.gurel.lib.dagger2.di.ProvidesActivityInjector
import timber.log.Timber

open class BaseApplication: Application(), ProvidesActivityInjector {
    lateinit var component: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        component = initComponent()
        component.inject(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
    private fun initComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder().application(this).build()
    }
    override fun getActivityInjector(): ActivityInjector {
        return component.activityInjector()
    }
}