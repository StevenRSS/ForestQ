package com.uc.forestq.repository

import com.uc.forestq.retrofit.EndPointAPI
import javax.inject.Inject

class ArticleRepository @Inject constructor(private val api: EndPointAPI) {

    suspend fun getArticleResults() = api.getArticle()

    suspend fun getFaunaResults() = api.getFauna()

    suspend fun getFloraResults() = api.getFlora()

    suspend fun getFaunaDetail() = api.getDetailFauna()

    suspend fun getFloraDetail() = api.getDetailFlora()

    suspend fun getArticleDetail() = api.getDetailArticle()
}