package com.eyup.gurel.lib.android.videorenderer.landing

import com.eyup.gurel.lib.adapter.monster.adapter.RecyclerDataSource
import com.eyup.gurel.lib.adapter.monster.item.RecyclerItem
import com.eyup.gurel.lib.android.base.ui.BottomScreenNavigator
import com.eyup.gurel.lib.android.base.ui.DefaultScreenNavigator
import com.eyup.gurel.lib.android.base.ui.ScreenNavigator
import com.eyup.gurel.lib.android.videorenderer.R
import com.eyup.gurel.lib.android.videorenderer.data.rest.api.CryptoServiceRepository
import com.eyup.gurel.lib.android.videorenderer.landing.model.AssetPair
import com.eyup.gurel.lib.android.videorenderer.landing.model.PriceDiscovery
import com.eyup.gurel.lib.dagger2.di.ForScreen
import com.eyup.gurel.lib.dagger2.di.ScreenScope
import com.eyup.gurel.lib.dagger2.lifecycle.DisposableManager
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import timber.log.Timber
import javax.inject.Inject

@ScreenScope
class LandingPresenter @Inject internal constructor(private val viewModel:LandingViewModel,
                                                                                                            private val cryptoServiceRepository: CryptoServiceRepository,
                                                                                                            private val screenNavigator: ScreenNavigator,
                                                                                                            @param:ForScreen private val disposableManager: DisposableManager,
                                                                                                            private val dataSource: RecyclerDataSource,
                                                                                                            private val moshi: Moshi):Landing{
            init{
                    disposableManager.add(cryptoServiceRepository.postTickerChangeSome( listOf( "ETHUSDT",  "ADAUSDT",
                        "DOTUSDT",  "SOLUSDT",
                        "MATICUSDT" )).
                    doOnSuccess{
                        val s = moshi.adapter<List<PriceDiscovery>>(
                            Types.newParameterizedType(List::class.java, PriceDiscovery::class.java)).toJson(it)

                        Timber.d("priceChangeList: $s")


                    }.
                    flatMapObservable{ Observable.fromIterable(it)}.
                    map{
                        AssetPair(
                        ticker = it.symbol,
                        lastPrice = it.lastPrice,
                        priceChange = it.priceChange,
                        percentChange = it.priceChangePercent,
                        id = getTickerOrder(it.symbol))
                    }.toList().
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe({
                        //Timber.d(it.toString())
                        dataSource.setData(it as List<RecyclerItem>)
                    },
                        { throwable ->
                            Timber.e(throwable)
                        })
                    )
            }

    override fun promptVideos() {
        disposableManager.add(
            screenNavigator.navigate(R.id.action_landingFragment_to_videosFragment).
            observeOn(AndroidSchedulers.mainThread()).
            subscribe( {

            },  {throwable ->
                Timber.e(throwable)
            }))
    }


    private fun getTickerOrderMap():Map<String,Long> = mapOf("BTCUSDT" to 1L,  "ETHUSDT" to 2L,  "ADAUSDT" to 3L,
        "DOTUSDT" to 4L,  "DOGEUSDT" to 5L,  "UNIUSDT"  to 6L,
        "BNBUSDT" to 7L, "LINKUSDT" to 8L, "SOLUSDT" to 9L,
        "MATICUSDT" to 10L, "XMRUSDT" to 11L, "LTCUSDT" to 12L,
        "ETHTRY" to 13L ,"BTCTRY" to 14L,"WAVESUSDT" to 15L,
        "XRPUSDT" to 16L, "HOTUSDT" to 17L, "TRXUSDT" to 18L)

    fun getTickerOrder(ticker:String) = getTickerOrderMap()[ticker]!!


}