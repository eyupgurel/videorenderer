package com.eyup.gurel.lib.android.videorenderer.landing.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PriceDiscovery(val symbol:String,
                          val priceChange:Double,
                          val priceChangePercent: Double,
                          val weightedAvgPrice:Double,
                          val prevClosePrice:Double,
                          val lastPrice:Double,
                          val lastQty:Double,
                          val bidPrice:Double,
                          val bidQty:Double,
                          val askPrice:Double,
                          val askQty:Double,
                          val openPrice:Double,
                          val highPrice:Double,
                          val lowPrice:Double,
                          val volume:Double,
                          val quoteVolume:Double,
                          val openTime:Long,
                          val closeTime:Long,
                          val firstId:Int,
                          val lastId:Int,
                          val count:Int)