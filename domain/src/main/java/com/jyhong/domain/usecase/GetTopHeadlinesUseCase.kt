package com.jyhong.domain.usecase

import com.jyhong.domain.repository.NewsRepository
import javax.inject.Inject

class GetTopHeadlinesUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(
        country: String?,
        language: String?,
        category: String?,
        source: String?,
        query: String?,
        page: Int,
        pageSize: Int
    ) = newsRepository.getTopHeadlines(
        country = country,
        language = language,
        category = category,
        source = source,
        query = query,
        page = page,
        pageSize = pageSize
    )
}