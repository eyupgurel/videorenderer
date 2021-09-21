package com.eyup.gurel.lib.android.videorenderer.config.format

/*
0 – prints a digit if provided, 0 otherwise
# – prints a digit if provided, nothing otherwise
. – indicate where to put the decimal separator
, – indicate where to put the grouping separator
*/

class Format {
    companion object {

        fun getPrecisionFormat(ticker: String): String =
            when (ticker) {
                "TRY" -> "#,##0.00"
                "USDT" -> "#,##0"
                "BTC" -> "#,##0.00000"
                "ETH" -> "#,##0.000000"
                "ETHTRY" -> "#,##0.0000"
                "ADAUSDT" -> "#,##0.00"
                "DOTUSDT" -> "#,##0.00"
                "DOGEUSDT" -> "#,##0"
                "UNIUSDT" -> "#,##0.00"
                "BNBUSDT" -> "#,##0.000"
                "LINKUSDT" -> "#,##0.00"
                "SOLUSDT" -> "#,##0.00"
                "MATICUSDT" -> "#,##0.0"
                "XMRUSDT" -> "#,##0.000"
                "LTCUSDT" -> "#,##0.000"
                "WAVESUSDT" -> "#,##0.00##"
                "XRPUSDT" ->  "#,##0.00##"
                "HOTUSDT" ->  "#,##0.00##"
                else -> "#,##0.00##"
                // throw IllegalArgumentException()
            }


        fun getOrderQuantityFormat(ticker: String): String =
            when (ticker) {
                "TRY" -> "#,##0"
                "USDT" -> "#,##0"
                "BTC" -> "#,##0.00000"
                "ETHTRY" -> "#,##0.0000"
                "ADAUSDT" -> "#,##0.00"
                "DOTUSDT" -> "#,##0.00"
                "DOGEUSDT" -> "#,##0"
                "UNIUSDT" -> "#,##0.00"
                "BNBUSDT" -> "#,##0.000"
                "LINKUSDT" -> "#,##0.00"
                "SOLUSDT" -> "#,##0.00"
                "MATICUSDT" -> "#,##0.0"
                "XMRUSDT" -> "#,##0.000"
                "LTCUSDT" -> "#,##0.000"
                "WAVESUSDT" -> "#,##0.00##"
                "XRPUSDT" ->  "#,##0.00##"
                "HOTUSDT" ->  "#,##0.00##"
                else -> "#,##0.00##"
                // throw IllegalArgumentException()
            }

        fun getAssetPriceFormat(ticker: String): String =
            when (ticker) {
                "TRY" -> "#,##0"
                "USDT" -> "#,##0"
                "BTCUSDT" -> "#,##0.00"
                "ETHTRY" -> "#,##0"
                "ADAUSDT" -> "#,##0.000"
                "DOTUSDT" -> "#,##0.00"
                "DOGEUSDT" -> "#,##0.0000"
                "UNIUSDT" -> "#,##0.00"
                "BNBUSDT" -> "#,##0.0"
                "LINKUSDT" -> "#,##0.00"
                "SOLUSDT" -> "#,##0.00"
                "MATICUSDT" -> "#,##0.000"
                "XMRUSDT" -> "#,##0.0"
                "LTCUSDT" -> "#,##0.0"
                "WAVESUSDT" -> "#,##0.00##"
                "XRPUSDT" ->  "#,##0.00##"
                "HOTUSDT" ->  "#,##0.00##"
                else -> "#,##0.00##"
                // throw IllegalArgumentException()
            }
    }
}