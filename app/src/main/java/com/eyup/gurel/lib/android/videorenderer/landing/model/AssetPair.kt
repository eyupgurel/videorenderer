package com.eyup.gurel.lib.android.videorenderer.landing.model

import androidx.room.PrimaryKey
import com.eyup.gurel.lib.adapter.monster.item.RecyclerItem
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AssetPair(
    @PrimaryKey
    val ticker: String,
    val lastPrice: Double,
    val priceChange: Double,
    val percentChange: Double,
    override val id: Long = when (ticker) {
        "BTCUSDT" -> 1L
        "ETHUSDT" -> 2L
        "ADAUSDT" -> 3L
        "DOTUSDT" -> 4L
        "DOGEUSDT" -> 5L
        "UNIUSDT" -> 6L
        "BNBUSDT" -> 7L
        "LINKUSDT" -> 8L
        "SOLUSDT" -> 9L
        "MATICUSDT" -> 10L
        "XMRUSDT" -> 11L
        "LTCUSDT" -> 12L
        "ETHTRY" -> 13L
        "BTCTRY" -> 14L
        "WAVESUSDT" -> 15L
        "XRPUSDT" -> 16L
        "HOTUSDT" -> 17L
        "TRXUSDT" -> 18L
        else ->
            throw IllegalArgumentException()
    }
) : RecyclerItem {
    override fun renderKey(): String ="AssetPair"
}
