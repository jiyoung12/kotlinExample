package com.jiyoung.kotilnexample.search

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.jiyoung.kotilnexample.ui.component.SearchBar

@Composable
fun SearchRoute(
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    SearchScreen(uiState = uiState)
}

@Composable
private fun SearchScreen(uiState: SearchViewModel.SearchUiState) {
    Column {
        SearchBar(value = "", onValueChange = {}) {

        }
    }
}

@Composable
@Preview
private fun PreviewSearchScreen() {
    SearchScreen(uiState = SearchViewModel.SearchUiState.Loading)
}
