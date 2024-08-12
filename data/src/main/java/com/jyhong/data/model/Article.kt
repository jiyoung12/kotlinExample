package com.jyhong.data.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkArticle(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String,
    val source: NetworkSource?,
    val title: String,
    val url: String?,
    val urlToImage: String?
)

