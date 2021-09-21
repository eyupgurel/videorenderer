package com.eyup.gurel.lib.android.videorenderer.networking

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class NetworkConfigModule {

   companion object{
       @Provides
       @Singleton
       @Named("base_rest_api_url")
       fun providesBaseRestUrl():String{
           return "https://alphaapi.futurance.com/"
       }
   }

}