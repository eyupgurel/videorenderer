package com.eyup.gurel.lib.android.videorenderer.base

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.eyup.gurel.lib.android.base.components.ActivityModule
import com.eyup.gurel.lib.android.base.ui.ScreenNavigatorModule
import com.eyup.gurel.lib.android.videorenderer.home.MainNavActivity
import com.eyup.gurel.lib.dagger2.di.ActivityKey
import com.eyup.gurel.lib.dagger2.di.ActivityScope
import com.eyup.gurel.lib.dagger2.di.AndroidActivityInjector
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import com.eyup.gurel.lib.android.videorenderer.base.ActivityBuildersModule.*
import com.eyup.gurel.lib.android.videorenderer.home.MainActivityScreenBuildersModule

@Module(subcomponents = [MainActivitySubcomponent::class])
abstract class ActivityBuildersModule {
    @Binds
    @IntoMap
    @ActivityKey(MainNavActivity::class)
    abstract fun bindMainActivitySubcomponentFactory(builder: MainActivitySubcomponent.Builder): AndroidInjector.Factory<out Activity>

    @ActivityScope
    @Subcomponent(modules = [ActivityModule::class,
                                                                ScreenNavigatorModule::class,
                                                               MainActivityScreenBuildersModule::class])
    interface MainActivitySubcomponent : AndroidActivityInjector<MainNavActivity> {
        @Subcomponent.Builder
        abstract class Builder : AndroidInjector.Builder<MainNavActivity>(){
            @BindsInstance
            abstract fun bindActivity(activity: AppCompatActivity)
            override fun seedInstance(instance: MainNavActivity) {
                bindActivity(instance)
            }
        }
    }
}