package com.eyup.gurel.lib.android.videorenderer.resource

import com.eyup.gurel.lib.android.videorenderer.R


class Resource {
    companion object{
        fun getAssetIcon(ticker:String):Int = when(ticker){
            "ETH" , "ETHUSD" , "ETHUSDT", "ETHTRY" -> R.drawable.ic_ethereum_eth_logo
            "ADA" ,"ADAUSD" , "ADAUSDT", "ADATRY" -> R.drawable.ic_cardano_ada_logo
            "DOT" , "DOTUSD" , "DOTUSDT"  , "DOTTRY"-> R.drawable.ic_polkadot_new_dot_logo
            "SOL",  "SOLUSD",  "SOLUSDT" ,  "SOLUTRY"-> R.drawable.ic_solana_sol_logo
            "MATIC", "MATICUSD",  "MATICUSDT" ,  "MATICTRY"-> R.drawable.ic_polygon_matic_logo
            else -> R.drawable.ic_ethereum_eth_logo
            // throw IllegalArgumentException()
        }
    }
}