package com.jyhong.domain.repository

import androidx.paging.PagingData
import com.jyhong.domain.model.Article
import com.jyhong.domain.model.Sort
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getEverything(
        query: String?,
        searchIn: String?,
        from: String?,
        to: String?,
        lang: String,
        sortBy: Sort,
    ): Flow<PagingData<Article>>

    suspend fun getSource(
        category: String,
        lang: String,
        country: String
    )

    suspend fun getTopHeadlines(
        country: String?,
        language: String?,
        category: String?,
        source: String?,
        query: String?,
        page: Int,
        pageSize: Int
    ): List<Article>
}