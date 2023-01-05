package com.uc.forestq.model

data class Article(
    val data: List<ArticleData>,
    val message: String,
    val status: Int
)