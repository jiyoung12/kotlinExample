package com.jiyoung.kotilnexample.explorer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.jiyoung.kotilnexample.ui.component.ExplorerError
import com.jiyoung.kotilnexample.ui.component.ExplorerList
import com.jiyoung.kotilnexample.ui.component.Top

@Composable
fun ExplorerRoute(
    viewModel: ExplorerViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    ExplorerScreen(uiState)
}

@Composable
private fun ExplorerScreen(uiState: ExplorerViewModel.NewsUiState) {
    Column {
        Top("Today") {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.clickable {
                    // TODO
                })
        }
        when (uiState) {
            ExplorerViewModel.NewsUiState.Error -> ExplorerError()
            ExplorerViewModel.NewsUiState.Loading -> {
                CircularProgressIndicator()
            }

            is ExplorerViewModel.NewsUiState.Success -> {
                ExplorerList(articles = uiState.articles, onArticleClicked = {})
            }
        }
    }
}


