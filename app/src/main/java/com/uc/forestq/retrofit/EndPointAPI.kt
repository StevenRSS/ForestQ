package com.uc.forestq.retrofit

import com.google.gson.JsonObject
import com.uc.forestq.model.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Response
import retrofit2.http.GET
import javax.inject.Singleton

interface EndPointAPI {

    @GET("/getArticle")
    suspend fun getArticle(
    ):Response<Article>

    @GET("/getFauna")
    suspend fun getFauna(
    ):Response<Fauna>

    @GET("/getFlora")
    suspend fun getFlora(
    ):Response<Flora>

    @GET("/getDetailFauna")
    suspend fun getDetailFauna(
    ):Response<FaunaData>

    @GET("/getDetailFlora")
    suspend fun getDetailFlora(
    ):Response<FloraData>

    @GET("/getDetailArticle")
    suspend fun getDetailArticle(
    ):Response<ArticleData>
}