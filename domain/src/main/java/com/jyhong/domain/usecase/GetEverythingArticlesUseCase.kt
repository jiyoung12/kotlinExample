package com.jyhong.domain.usecase

import com.jyhong.domain.repository.NewsRepository
import javax.inject.Inject

class GetEverythingArticlesUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(
        query: String?,
        searchIn: String?,
        from: String?,
        to: String?,
        lang: String?,
        sortBy: String?,
        page: Long,
        pageSize: Int
    ) = newsRepository.getEverything(
        query = null,
        searchIn = null,
        from = "",
        to = "",
        lang = "",
        sortBy = "",
        page = 0,
        pageSize = 20
    )
}