package com.jyhong.domain.repository

import com.jyhong.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getEverything(
        query: String?,
        searchIn: String?,
        from: String?,
        to: String?,
        lang: String?,
        sortBy: String?,
        page: Long,
        pageSize: Int
    ): Flow<List<Article>>

    suspend fun getSource(
        category: String,
        lang: String,
        country: String
    )


    suspend fun getTopHeadlines(
        country: String?,
        language : String?,
        category: String?,
        source: String?,
        query: String?,
        page: Int,
        pageSize: Int
    ): List<Article>
}