package com.uc.forestq.retrofit

import com.uc.forestq.helper.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getRetrofitServiceInstance(retrofit: Retrofit):
    EndPointAPI{
        return retrofit.create(EndPointAPI::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitServiceUnstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}