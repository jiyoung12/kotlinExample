package com.jyhong.data.datasource

import com.jyhong.data.model.NetworkArticle
import com.jyhong.domain.model.Sort

interface NewsNetworkDataSource {
    suspend fun getTopHeadlines(
        country: String?,
        language: String?,
        category: String?,
        source: String?,
        query: String?,
        page: Int,
        pageSize: Int
    ): List<NetworkArticle>

    suspend fun getSource(): List<Any>
    suspend fun getEverything(
        query: String?,
        searchIn: String?,
        from: String?,
        to: String?,
        lang: String?,
        sortBy: Sort,
        page: Long,
        pageSize: Int
    ): List<NetworkArticle>
}