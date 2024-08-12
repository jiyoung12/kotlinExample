package com.jyhong.data.mapper

import com.jyhong.data.model.NetworkArticle
import com.jyhong.domain.model.Article

internal fun NetworkArticle.toModel() = Article(
    author = author,
    content = content,
    description = description,
    publishedAt = publishedAt,
    source = source?.toModel(),
    title = title,
    url = url,
    urlToImage = urlToImage
)