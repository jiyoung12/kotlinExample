package com.jiyoung.kotilnexample.server.model

data class NewsItemContent(
    var articles: List<Article>,
    var status: String,
    var totalResults: Int
)