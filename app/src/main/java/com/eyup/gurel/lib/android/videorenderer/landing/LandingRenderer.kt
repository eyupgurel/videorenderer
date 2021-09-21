package com.eyup.gurel.lib.android.videorenderer.landing

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.eyup.gurel.lib.adapter.monster.item.ItemRenderer
import com.eyup.gurel.lib.android.videorenderer.R
import com.eyup.gurel.lib.android.videorenderer.config.format.Format
import com.eyup.gurel.lib.android.videorenderer.landing.model.AssetPair
import com.eyup.gurel.lib.android.videorenderer.resource.Resource
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import javax.inject.Inject
import javax.inject.Provider


class LandingRenderer @Inject internal constructor(private val context: Context,
                                                   private val presenterProvider: Provider<LandingPresenter>
) : ItemRenderer<AssetPair> {
    override fun layoutRes(): Int {
        return R.layout.view_asset_pair_item
    }

    override fun createView(parent: ViewGroup): View {
        val view = LayoutInflater.from(parent.context).inflate(layoutRes(), parent, false)
        view.tag = ViewBinder(view,  context, presenterProvider.get())
        return view
    }
    override fun render(itemView: View, item: AssetPair) {
        (itemView.tag as ViewBinder).bind(item)
    }

    internal class ViewBinder(private val itemView: View, private val context: Context, presenter: LandingPresenter) {
        private var image: ImageView = itemView.findViewById(R.id.ivAssetPair)
        private var ticker: TextView =itemView.findViewById(R.id.tvTicker)
        private var price: TextView =itemView.findViewById(R.id.tvLastPrice)
        private var amountChange: TextView =itemView.findViewById(R.id.tvAmountChange)
        private var percentChange: TextView =itemView.findViewById(R.id.tvPercentChange)
        private lateinit var assetPair: AssetPair

        fun bind(assetPair: AssetPair) {
            this.assetPair = assetPair
            Glide.with(image.context).load(Resource.getAssetIcon(assetPair.ticker)).into(image)
            ticker.text = assetPair.ticker
            price.text = assetPair.lastPrice.toString()

            DecimalFormat(
                Format.getAssetPriceFormat(assetPair.ticker),
                DecimalFormatSymbols(context.resources.configuration.locales[0])
            ).format(assetPair.percentChange).also{amountChange.text = it}

            "% ${
                DecimalFormat(
                    "#,##0.00",
                    DecimalFormatSymbols(context.resources.configuration.locales[0])
                ).format(assetPair.percentChange)}".also { percentChange.text = it }
            val color = when {
                assetPair.priceChange > 0 -> context.getColor(R.color.green)
                assetPair.priceChange < 0 -> context.getColor(R.color.red)
                else -> context.getColor(R.color.textColorInactive)
            }
            amountChange.setTextColor(color)
            percentChange.setTextColor(color)
        }

        init{
            itemView.setOnClickListener{
                presenter.promptVideos()
            }
        }
    }
}
