package com.eyup.gurel.lib.android.videorenderer.data.rest.api

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
object CryptoServiceModule {
    @Provides
    @Singleton
    fun providesCryptoService(@Named("base") retrofit: Retrofit):CryptoService = retrofit.create(CryptoService::class.java)
}