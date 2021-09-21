package com.eyup.gurel.lib.android.videorenderer.data.rest.api

import com.eyup.gurel.lib.android.videorenderer.landing.model.PriceDiscovery
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CryptoServiceRequester @Inject internal constructor(private val service:CryptoService) {
    fun postTickerChangeSome(tickerList:List<String>): Single<List<PriceDiscovery>> = service.postTickerChangeSome(tickerList)
}