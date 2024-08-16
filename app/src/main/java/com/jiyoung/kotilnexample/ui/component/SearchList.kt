package com.jiyoung.kotilnexample.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.SubcomposeAsyncImage
import com.jiyoung.kotilnexample.common.DateTimeHelper
import com.jiyoung.kotilnexample.ui.ArticlesResourcePreviewParameterProvider
import com.jiyoung.kotilnexample.ui.NewsBackground
import com.jiyoung.kotilnexample.ui.NewsTheme
import com.jyhong.domain.model.Article
import kotlinx.coroutines.flow.flowOf


@Composable
fun SearchList(
    query: String?,
    articles: LazyPagingItems<Article>,
    onArticleClicked: (Article) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(450.dp),
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
    ) {
        for (i in 0 until articles.itemCount) {
            newsCardItem(
                query = query,
                article = articles[i] ?: continue,
                onArticleClicked = onArticleClicked
            )
        }
    }
}

fun LazyGridScope.newsCardItem(
    query: String?,
    article: Article,
    onArticleClicked: (Article) -> Unit
) {
    item {
        Row(modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onArticleClicked(article) }) {
            SubcomposeAsyncImage(
                model = article.urlToImage,
                contentDescription = article.title,
                modifier = Modifier
                    .width(120.dp)
                    .aspectRatio(4f / 3f)
                    .background(
                        MaterialTheme.colorScheme.surfaceContainer,
                        RoundedCornerShape(4.dp)
                    )
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop,
                loading = {
                    CircularProgressIndicator(
                        modifier = Modifier.size(36.dp)
                    )
                },
                error = {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.surfaceContainerHigh,
                        modifier = Modifier.size(36.dp)
                    )
                }

            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                val annotatedName = if (query != null && article.title.contains(query)) {
                    buildAnnotatedString {
                        val split = article.title.split(query)
                        split.forEachIndexed { index, s ->
                            append(s)
                            if (index < split.size - 1) {
                                withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                                    append(query)
                                }
                            }
                        }
                    }
                } else AnnotatedString(article.title)
                Text(
                    text = annotatedName,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Medium),
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                article.description?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onBackground,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = article.author ?: article.source?.name ?: "",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = DateTimeHelper.formatDateTime(article.publishedAt),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

            }
        }
    }
}

@Preview
@Preview(device = Devices.TABLET)
@Composable
fun PreviewSearchList(
    @PreviewParameter(ArticlesResourcePreviewParameterProvider::class)
    articles: List<Article>,
) {
    NewsTheme {
        NewsBackground {
            SearchList(
                query = "골",
                articles = flowOf(PagingData.from(articles)).collectAsLazyPagingItems()
            ) {}
        }
    }
}