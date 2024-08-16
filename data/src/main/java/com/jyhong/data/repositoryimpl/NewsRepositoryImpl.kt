package com.jyhong.data.repositoryimpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.jyhong.data.GetEverythingPagingSource
import com.jyhong.data.datasource.NewsNetworkDataSource
import com.jyhong.data.mapper.toModel
import com.jyhong.data.model.NetworkArticle
import com.jyhong.domain.model.Article
import com.jyhong.domain.model.Sort
import com.jyhong.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsNetworkDataSource: NewsNetworkDataSource
) : NewsRepository {

    override suspend fun getEverything(
        query: String?,
        searchIn: String?,
        from: String?,
        to: String?,
        lang: String,
        sortBy: Sort
    ): Flow<PagingData<Article>> = Pager(PagingConfig(pageSize = 20)) {
        GetEverythingPagingSource(
            newsNetworkDataSource,
            query = query,
            searchIn = searchIn,
            from = from,
            to = to,
            lang = lang,
            sortBy = sortBy
        )
    }.flow

    override suspend fun getTopHeadlines(
        country: String?,
        language: String?,
        category: String?,
        source: String?,
        query: String?,
        page: Int,
        pageSize: Int
    ) = newsNetworkDataSource.getTopHeadlines(
        country = country,
        language = language,
        category = category,
        source = source,
        query = query,
        page = page,
        pageSize = pageSize
    ).map(NetworkArticle::toModel)


    override suspend fun getSource(category: String, lang: String, country: String) {

    }
}