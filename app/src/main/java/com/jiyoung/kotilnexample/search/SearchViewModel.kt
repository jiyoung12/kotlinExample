package com.jiyoung.kotilnexample.search

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jiyoung.kotilnexample.common.result.Result
import com.jiyoung.kotilnexample.common.result.asResult
import com.jyhong.domain.model.Article
import com.jyhong.domain.usecase.GetEverythingArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getEverythingArticlesUseCase: GetEverythingArticlesUseCase
) : ViewModel() {

    @OptIn(ExperimentalCoroutinesApi::class)
    val uiState = savedStateHandle.getStateFlow<String?>(QUERY, "")
        .flatMapLatest {
            getEverythingArticlesUseCase.invoke(
                query = it,
                searchIn = null,
                from = null,
                to = null,
                lang = null,
                sortBy = null,
                page = 0,
                pageSize = 20
            )
        }.asResult()
        .map {
            when (it) {
                is Result.Error -> SearchUiState.Error
                Result.Loading -> SearchUiState.Loading
                is Result.Success -> SearchUiState.Success("", it.data)
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000L), SearchUiState.Loading)

    sealed class SearchUiState {
        data object Loading : SearchUiState()
        data class Success(val keyword: String, val articles: List<Article>) : SearchUiState()
        data object Error : SearchUiState()
    }
}

const val QUERY = "query"