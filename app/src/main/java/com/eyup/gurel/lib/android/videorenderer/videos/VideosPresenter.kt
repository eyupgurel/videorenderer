package com.eyup.gurel.lib.android.videorenderer.videos

import com.eyup.gurel.lib.adapter.monster.adapter.RecyclerDataSource
import com.eyup.gurel.lib.android.videorenderer.data.rest.api.CryptoServiceRepository
import com.eyup.gurel.lib.android.videorenderer.videos.model.MediaItem
import com.eyup.gurel.lib.dagger2.di.ForScreen
import com.eyup.gurel.lib.dagger2.di.ScreenScope
import com.eyup.gurel.lib.dagger2.lifecycle.DisposableManager
import com.squareup.moshi.Moshi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import timber.log.Timber
import javax.inject.Inject


@ScreenScope
class VideosPresenter @Inject internal constructor(private val viewModel: VideosViewModel,
                                                                                                           private val cryptoServiceRepository: CryptoServiceRepository,
                                                                                                           private val dataSource: RecyclerDataSource,
                                                                                                           private val moshi: Moshi,
                                                                                                           @param:ForScreen private val disposableManager: DisposableManager):Videos{
           init{
               Single.just(listOf(MediaItem(url="""https://archive.org/download/BigBuckBunny_124/Content/big_buck_bunny_720p_surround.mp4""", id = 1L),
                                                    MediaItem(url="""https://archive.org/download/BigBuckBunny_124/Content/big_buck_bunny_720p_surround.mp4""", id = 1L),
                                                    MediaItem(url="""https://archive.org/download/BigBuckBunny_124/Content/big_buck_bunny_720p_surround.mp4""", id = 1L),
                                                    MediaItem(url="""https://archive.org/download/BigBuckBunny_124/Content/big_buck_bunny_720p_surround.mp4""", id = 1L),
                                                    MediaItem(url="""https://archive.org/download/BigBuckBunny_124/Content/big_buck_bunny_720p_surround.mp4""", id = 1L)),
                   ).observeOn(AndroidSchedulers.mainThread()).
               subscribe ( { dataSource.setData(it) },
                   {throwable -> Timber.e(throwable)}
                   )
           }

}