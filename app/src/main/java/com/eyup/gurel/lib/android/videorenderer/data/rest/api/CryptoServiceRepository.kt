package com.eyup.gurel.lib.android.videorenderer.data.rest.api

import android.content.Context
import com.eyup.gurel.lib.android.videorenderer.landing.model.PriceDiscovery
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class CryptoServiceRepository @Inject internal constructor(private val context: Context,
                                                                                                                           private val requesterProvider: Provider<CryptoServiceRequester>,
                                                                                                                           @param:Named("network_scheduler") private val scheduler: Scheduler)
{
    fun postTickerChangeSome(tickerList:List<String>): Single<List<PriceDiscovery>> = requesterProvider.get().postTickerChangeSome(tickerList).subscribeOn(scheduler)
}