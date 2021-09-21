package com.eyup.gurel.lib.android.videorenderer.videos

import android.content.Context
import android.text.Html
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import com.eyup.gurel.lib.adapter.monster.item.ItemRenderer
import com.eyup.gurel.lib.android.videorenderer.R
import com.eyup.gurel.lib.android.videorenderer.videos.model.MediaItem
import java.nio.charset.StandardCharsets
import javax.inject.Inject
import javax.inject.Provider

class VideosRenderer @Inject internal constructor(private val context: Context, private val presenterProvider: Provider<VideosPresenter>):ItemRenderer<MediaItem> {
    override fun createView(parent: ViewGroup): View {
        val view = LayoutInflater.from(parent.context).inflate(layoutRes(),parent,false)
        view.tag = ViewBinder(view, context, presenterProvider.get())
        return view
    }
    override fun layoutRes(): Int {
        return R.layout.view_video_item
    }
    override fun render(itemView: View, item: MediaItem) {
        (itemView.tag as ViewBinder).bind(item)
    }
    internal class ViewBinder(private val itemView:View, private val context:Context, private val presenter:VideosPresenter){
        private var mediaItemWV: WebView = itemView.findViewById(R.id.mediaItem)
        private lateinit var mediaItem: MediaItem
        init{
            mediaItemWV.webChromeClient = WebChromeClient()
            mediaItemWV.webViewClient = WebViewClient()
        }
        fun bind(mediaItem:MediaItem){
            this.mediaItem = mediaItem
            mediaItemWV.loadUrl(mediaItem.url)
        }
    }
}