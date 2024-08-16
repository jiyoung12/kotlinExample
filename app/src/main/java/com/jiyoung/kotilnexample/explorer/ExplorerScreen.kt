package com.jiyoung.kotilnexample.explorer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.jiyoung.kotilnexample.ui.component.ErrorPage
import com.jiyoung.kotilnexample.ui.component.ExplorerList
import com.jiyoung.kotilnexample.ui.component.LoadingPage
import com.jiyoung.kotilnexample.ui.component.Top

@Composable
fun ExplorerRoute(
    moveToSearchScreen: () -> Unit,
    viewModel: ExplorerViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    ExplorerScreen(uiState, moveToSearchScreen)
}

@Composable
private fun ExplorerScreen(uiState: ExplorerViewModel.NewsUiState, moveToSearchScreen: () -> Unit) {
    Column {
        Top("Today") {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.clickable(onClick = moveToSearchScreen)
            )
        }
        when (uiState) {
            ExplorerViewModel.NewsUiState.Error -> ErrorPage("잠시 후 다시 시도해주세요.")
            ExplorerViewModel.NewsUiState.Loading -> LoadingPage()
            is ExplorerViewModel.NewsUiState.Success -> {
                ExplorerList(articles = uiState.articles, onArticleClicked = {})
            }
        }
    }
}

const val EXPLORER_ROUTE = "explorer"

