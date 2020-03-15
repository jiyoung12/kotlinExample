package com.jiyoung.kotilnexample.server.model

data class Article(
    var author: String = "",
    var content: String = "",
    var description: String ="",
    var publishedAt: String = "",
    var source: Source = Source("",""),
    var title: String = "",
    var url: String = "",
    var urlToImage: String = ""
)

data class Source(
    var id: String,
    var name: String
)