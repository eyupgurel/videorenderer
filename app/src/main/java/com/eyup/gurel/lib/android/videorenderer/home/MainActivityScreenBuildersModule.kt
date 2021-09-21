package com.eyup.gurel.lib.android.videorenderer.home

import androidx.fragment.app.Fragment
import com.eyup.gurel.lib.android.base.components.ScreenModule
import com.eyup.gurel.lib.android.videorenderer.landing.LandingFragment
import com.eyup.gurel.lib.android.videorenderer.landing.LandingScreenModule
import com.eyup.gurel.lib.dagger2.di.FragmentKey
import com.eyup.gurel.lib.dagger2.di.ScreenComponent
import com.eyup.gurel.lib.dagger2.di.ScreenScope
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import com.eyup.gurel.lib.android.videorenderer.home.MainActivityScreenBuildersModule.*
import com.eyup.gurel.lib.android.videorenderer.videos.VideosFragment
import com.eyup.gurel.lib.android.videorenderer.videos.VideosScreenModule

@Module(subcomponents = [LandingFragmentSubcomponent::class, VideosFragmentSubcomponent::class])
abstract class MainActivityScreenBuildersModule {
    @Binds
    @IntoMap
    @FragmentKey(LandingFragment::class)
    abstract fun bindLandingFragmentSubcomponentFactory(factory: LandingFragmentSubcomponent.Factory): AndroidInjector.Factory<out Fragment>
    @ScreenScope
    @Subcomponent(modules = [ScreenModule::class, LandingScreenModule::class])
    interface LandingFragmentSubcomponent : ScreenComponent<LandingFragment> {
        @Subcomponent.Factory
        interface Factory : AndroidInjector.Factory<LandingFragment>
    }

    @Binds
    @IntoMap
    @FragmentKey(VideosFragment::class)
    abstract fun bindVideosFragmentSubcomponentFactory(factory: VideosFragmentSubcomponent.Factory): AndroidInjector.Factory<out Fragment>
    @ScreenScope
    @Subcomponent(modules = [ScreenModule::class, VideosScreenModule::class])
    interface VideosFragmentSubcomponent : ScreenComponent<VideosFragment> {
        @Subcomponent.Factory
        interface Factory : AndroidInjector.Factory<VideosFragment>
    }


}