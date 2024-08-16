package com.jiyoung.kotilnexample.search

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jiyoung.kotilnexample.common.DeviceManager
import com.jyhong.domain.model.Sort
import com.jyhong.domain.usecase.GetEverythingArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    getEverythingArticlesUseCase: GetEverythingArticlesUseCase,
    deviceManager: DeviceManager
) : ViewModel() {

    val uiState = combine(
        savedStateHandle.getStateFlow<String?>(QUERY, null),
        savedStateHandle.getStateFlow(SORT, Sort.publishedAt)
    ) { query, sort ->
        SearchUiState(
            query = query,
            sortBy = sort
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000L), SearchUiState())

    @OptIn(ExperimentalCoroutinesApi::class)
    val articles = uiState.flatMapLatest {
        getEverythingArticlesUseCase.invoke(
            query = it.query,
            searchIn = null,
            from = null,
            to = null,
            lang = deviceManager.getLanguageCode(),
            sortBy = it.sortBy,
        )
    }

    fun saveSearchQuery(query: String) {
        savedStateHandle[QUERY] = query
    }

    fun saveSearchSortBy(sortBy: Sort) {
        savedStateHandle[SORT] = sortBy
    }

    data class SearchUiState(
        val query: String? = "",
        val sortBy: Sort = Sort.publishedAt,
    )
}

const val QUERY = "query"
const val SORT = "sort"