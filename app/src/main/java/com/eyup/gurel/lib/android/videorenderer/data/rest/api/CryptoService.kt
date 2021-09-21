package com.eyup.gurel.lib.android.videorenderer.data.rest.api

import com.eyup.gurel.lib.android.videorenderer.landing.model.PriceDiscovery
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface CryptoService {
    @POST("ticker/change/some")
    fun postTickerChangeSome(@Body tickerList:List<String>): Single<List<PriceDiscovery>>
}