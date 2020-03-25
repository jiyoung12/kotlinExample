package com.jiyoung.kotilnexample.server.model

data class NewsItemContent(
    var articles: ArrayList<Article>,
    var status: String,
    var totalResults: Int
)