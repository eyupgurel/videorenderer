package com.eyup.gurel.lib.android.videorenderer.videos.model

import com.eyup.gurel.lib.adapter.monster.item.RecyclerItem
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MediaItem(val url:String, override val id: Long): RecyclerItem {
    override fun renderKey(): String {
        return "MediaItem"
    }
}
