package com.jiyoung.kotilnexample.explorer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jiyoung.kotilnexample.common.DeviceManager
import com.jiyoung.kotilnexample.common.result.Result
import com.jiyoung.kotilnexample.common.result.asResult
import com.jyhong.domain.model.Article
import com.jyhong.domain.model.Category
import com.jyhong.domain.usecase.GetTopHeadlinesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

@HiltViewModel
class ExplorerViewModel @Inject constructor(
    private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase,
    private val deviceManager: DeviceManager
) : ViewModel() {

    val uiState = flow {
        emit(topHeadlines())
    }.asResult()
        .map {
            when (it) {
                is Result.Error -> NewsUiState.Error
                Result.Loading -> NewsUiState.Loading
                is Result.Success -> NewsUiState.Success(it.data.flattenSortedBy())
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), NewsUiState.Loading)

    private fun List<List<Pair<Category, Article>>>.flattenSortedBy() =
        this.flatten()
            .distinctBy { it.second.title } // 제목 기준으로 중복 제거
            .sortedByDescending { it.second.publishedAt }

    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun topHeadlines() = Category.entries.asFlow().flatMapMerge { category ->
        flowOf(getTopHeadlinesUseCase(
            country = deviceManager.getLocaleCode(),
            language = deviceManager.getLanguageCode(),
            category = category.name,
            source = null,
            query = null,
            page = 0,
            pageSize = 20
        ).map {
            Pair(category, it)
        })
    }.toList()

    sealed class NewsUiState {
        data object Loading : NewsUiState()
        data class Success(val articles: List<Pair<Category, Article>>) : NewsUiState()
        data object Error : NewsUiState()
    }
}