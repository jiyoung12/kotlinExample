package com.jyhong.data.datasource

import com.jyhong.data.model.NetworkArticle

interface NewsNetworkDataSource {
    suspend fun getTopHeadlines(
        country: String?,
        language : String?,
        category: String?,
        source: String?,
        query: String?,
        page: Int,
        pageSize: Int
    ): List<NetworkArticle>

    suspend fun getSource(): List<Any>
    suspend fun getEverything(q: String?, apiKey: String, page: Long, pageSize: Int): List<NetworkArticle>
}