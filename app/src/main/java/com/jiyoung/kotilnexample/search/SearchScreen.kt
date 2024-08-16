package com.jiyoung.kotilnexample.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.jiyoung.kotilnexample.ui.ArticlesResourcePreviewParameterProvider
import com.jiyoung.kotilnexample.ui.component.ErrorPage
import com.jiyoung.kotilnexample.ui.component.LoadingPage
import com.jiyoung.kotilnexample.ui.component.SearchBar
import com.jiyoung.kotilnexample.ui.component.SearchList
import com.jyhong.domain.model.Article
import com.jyhong.domain.model.Sort
import kotlinx.coroutines.flow.flowOf

@Composable
fun SearchRoute(
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    val articles = viewModel.articles.collectAsLazyPagingItems()
    SearchScreen(
        uiState = uiState,
        articles = articles,
        onSearchTrigger = viewModel::saveSearchQuery,
        onSortByChanged = viewModel::saveSearchSortBy,
        onArticleClicked = { // TODO
        })
}

@Composable
private fun SearchScreen(
    uiState: SearchViewModel.SearchUiState,
    articles: LazyPagingItems<Article>,
    onSearchTrigger: (String) -> Unit,
    onSortByChanged: (Sort) -> Unit,
    onArticleClicked: (Article) -> Unit
) {
    val (input, setText) = remember { mutableStateOf(uiState.query ?: "") }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        SearchBar(
            modifier = Modifier.padding(horizontal = 12.dp),
            value = input,
            onValueChange = setText,
            onSearchTriggered = { onSearchTrigger(input) }
        )
        when (articles.loadState.refresh) {
            is LoadState.Error -> ErrorPage(message = "잠시 후 다시 시도해주세요.")
            LoadState.Loading -> LoadingPage()
            is LoadState.NotLoading -> SearchList(
                query = uiState.query,
                articles = articles,
                onArticleClicked = onArticleClicked
            )
        }
    }
}

@Composable
@Preview
private fun PreviewSearchScreen(
    @PreviewParameter(ArticlesResourcePreviewParameterProvider::class)
    articles: List<Article>,
) {
    SearchScreen(
        uiState = SearchViewModel.SearchUiState(query = "PREVIEW"),
        articles = flowOf(
            PagingData.from(
                articles, sourceLoadStates = LoadStates(
                    refresh = LoadState.NotLoading(false),
                    append = LoadState.NotLoading(false),
                    prepend = LoadState.NotLoading(false)
                )
            )
        ).collectAsLazyPagingItems(),
        onSearchTrigger = {},
        onSortByChanged = {},
        onArticleClicked = {},

        )
}

fun NavController.navigateToSearch() {
    navigate(SEARCH_ROUTE)
}

const val SEARCH_ROUTE = "search"
