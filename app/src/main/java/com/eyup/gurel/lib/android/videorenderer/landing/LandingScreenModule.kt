package com.eyup.gurel.lib.android.videorenderer.landing

import com.eyup.gurel.lib.adapter.monster.adapter.RecyclerDataSource
import com.eyup.gurel.lib.adapter.monster.item.ItemRenderer
import com.eyup.gurel.lib.adapter.monster.item.RecyclerItem
import com.eyup.gurel.lib.adapter.monster.item.RenderKey
import com.eyup.gurel.lib.android.videorenderer.landing.model.AssetPair
import com.eyup.gurel.lib.dagger2.di.ScreenScope
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class LandingScreenModule {
    @Binds
    abstract fun bindLandingPresenter(landingPresenter: LandingPresenter): Landing

    @Binds
    @IntoMap
    @RenderKey("AssetPair")
    abstract fun bindLandingRenderer(landingRenderer: LandingRenderer): ItemRenderer<out RecyclerItem>

    companion object {

        @Provides
        @ScreenScope
        fun provideAssetPairMap(): MutableMap<String, AssetPair> {
            return mutableMapOf(
                "BTCUSDT" to AssetPair(
                    ticker = "BTCUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 1L
                ),
                "ETHUSDT" to AssetPair(
                    ticker = "ETHUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 2L
                ),
                "ADAUSDT" to AssetPair(
                    ticker = "ADAUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 3L
                ),
                "DOTUSDT" to AssetPair(
                    ticker = "DOTUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 4L
                ),
                "DOGEUSDT" to AssetPair(
                    ticker = "DOGEUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 5L
                ),
                "UNIUSDT" to AssetPair(
                    ticker = "UNIUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 6L
                ),
                "BNBUSDT" to AssetPair(
                    ticker = "BNBUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 7L
                ),
                "LINKUSDT" to AssetPair(
                    ticker = "LINKUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 8L
                ),
                "SOLUSDT" to AssetPair(
                    ticker = "SOLUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 9L
                ),
                "MATICUSDT" to AssetPair(
                    ticker = "MATICUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 10L
                ),
                "XMRUSDT" to AssetPair(
                    ticker = "XMRUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 11L
                ),
                "LTCUSDT" to AssetPair(
                    ticker = "LTCUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 12L
                ),
                "ETHTRY" to AssetPair(
                    ticker = "ETHTRY",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 13L
                ),
                "BTCTRY" to AssetPair(
                    ticker = "BTCTRY",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 14L
                ),
                "WAVESUSDT" to AssetPair(
                    ticker = "WAVESUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 15L
                ),
                "XRPUSDT" to AssetPair(
                    ticker = "XRPUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 16L
                ),
                "HOTUSDT" to AssetPair(
                    ticker = "HOTUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 17L
                ),
                "TRXUSDT" to AssetPair(
                    ticker = "TRXUSDT",
                    lastPrice = 0.0,
                    priceChange = 0.0,
                    percentChange = 0.0,
                    id = 18L
                )
            )

        }

        @Provides
        @ScreenScope
        fun provideRecyclerDataSource(renderers: Map<String, @JvmSuppressWildcards ItemRenderer<out RecyclerItem>>): RecyclerDataSource {
            return RecyclerDataSource(renderers)
        }
    }
}
