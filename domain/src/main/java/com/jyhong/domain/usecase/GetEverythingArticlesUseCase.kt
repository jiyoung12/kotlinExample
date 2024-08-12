package com.jyhong.domain.usecase

import com.jyhong.domain.repository.NewsRepository
import javax.inject.Inject

class GetEverythingArticlesUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    suspend operator fun invoke() = newsRepository.getEverything(null, null, "", "", "", "", 0, 20)
}