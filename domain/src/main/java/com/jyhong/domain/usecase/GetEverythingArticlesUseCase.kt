package com.jyhong.domain.usecase

import com.jyhong.domain.model.Sort
import com.jyhong.domain.repository.NewsRepository
import javax.inject.Inject

class GetEverythingArticlesUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(
        query: String?,
        searchIn: String?,
        from: String?,
        to: String?,
        lang: String,
        sortBy: Sort
    ) = newsRepository.getEverything(
        query = query,
        searchIn = searchIn,
        from = from,
        to = to,
        lang = lang,
        sortBy = sortBy
    )
}