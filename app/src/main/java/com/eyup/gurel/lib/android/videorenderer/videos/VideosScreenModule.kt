package com.eyup.gurel.lib.android.videorenderer.videos

import com.eyup.gurel.lib.adapter.monster.adapter.RecyclerDataSource
import com.eyup.gurel.lib.adapter.monster.item.ItemRenderer
import com.eyup.gurel.lib.adapter.monster.item.RecyclerItem
import com.eyup.gurel.lib.adapter.monster.item.RenderKey
import com.eyup.gurel.lib.dagger2.di.ScreenScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class VideosScreenModule {

    @Binds
    abstract fun bindVideosPresenter(videosPresenter: VideosPresenter): Videos
    @Binds
    @IntoMap
    @RenderKey("MediaItem")
    abstract  fun bindVideosRenderer(videosRenderer: VideosRenderer): ItemRenderer<out RecyclerItem>

    companion object{
        @Provides
        @ScreenScope
        fun providesRecyclerDataSource(renderers:Map<String, @JvmSuppressWildcards ItemRenderer<out RecyclerItem>>):RecyclerDataSource{
            return RecyclerDataSource(renderers)
        }
    }

}