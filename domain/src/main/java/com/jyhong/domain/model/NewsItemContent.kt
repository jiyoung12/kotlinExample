package com.jiyoung.kotilnexample.server.model

import com.jyhong.domain.model.Article

data class NewsItemContent(
    var articles: ArrayList<Article>,
    var status: String,
    var totalResults: Int
)