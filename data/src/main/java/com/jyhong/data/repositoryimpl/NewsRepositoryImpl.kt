package com.jyhong.data.repositoryimpl

import com.jyhong.data.datasource.NewsNetworkDataSource
import com.jyhong.data.mapper.toModel
import com.jyhong.data.model.NetworkArticle
import com.jyhong.domain.repository.NewsRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsNetworkDataSource: NewsNetworkDataSource
) :
    NewsRepository {

    override suspend fun getEverything(
        query: String?,
        searchIn: String?,
        from: String?,
        to: String?,
        lang: String?,
        sortBy: String?,
        page: Long,
        pageSize: Int
    ) = flow {
        emit(
            newsNetworkDataSource.getEverything(
                q = query,
                apiKey = "1",
                page = page,
                pageSize = pageSize
            ).map(NetworkArticle::toModel)
        )
    }

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