package com.eyup.gurel.lib.android.videorenderer.base

import android.app.Application
import android.content.Context
import com.eyup.gurel.lib.android.base.components.ApplicationModule
import com.eyup.gurel.lib.android.base.networking.BaseServiceModule

import com.eyup.gurel.lib.android.videorenderer.data.rest.api.CryptoServiceModule
import com.eyup.gurel.lib.android.videorenderer.networking.NetworkConfigModule
import com.eyup.gurel.lib.dagger2.di.ActivityInjector
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,
                                                    ActivityBuildersModule::class,
                                                    BaseServiceModule::class,
                                                    NetworkConfigModule::class,
                                                    CryptoServiceModule::class])
interface ApplicationComponent: AndroidInjector<BaseApplication> {
    fun context(): Context
    fun activityInjector(): ActivityInjector
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}