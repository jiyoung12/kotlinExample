package com.jiyoung.kotilnexample.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.jiyoung.kotilnexample.common.DateTimeHelper
import com.jiyoung.kotilnexample.ui.ArticlesResourcePreviewParameterProvider
import com.jiyoung.kotilnexample.ui.NewsBackground
import com.jiyoung.kotilnexample.ui.NewsTheme
import com.jiyoung.kotilnexample.ui.theme.BusinessColor
import com.jiyoung.kotilnexample.ui.theme.EntertainmentColor
import com.jiyoung.kotilnexample.ui.theme.GeneralColor
import com.jiyoung.kotilnexample.ui.theme.HealthColor
import com.jiyoung.kotilnexample.ui.theme.ScienceColor
import com.jiyoung.kotilnexample.ui.theme.SportsColor
import com.jiyoung.kotilnexample.ui.theme.TechnologyColor
import com.jyhong.domain.model.Article
import com.jyhong.domain.model.Category
import com.jyhong.kotilnexample.R


@Composable
fun ExplorerList(
    articles: List<Pair<Category, Article>>,
    onArticleClicked: (Article) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(400.dp),
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
    ) {
        articles.forEach {
            newsTimelineItem(
                category = it.first,
                article = it.second,
                onArticleClicked = onArticleClicked
            )
        }
    }
}


fun LazyGridScope.newsTimelineItem(
    category: Category,
    article: Article,
    onArticleClicked: (Article) -> Unit
) {
    item {
        Row(modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onArticleClicked(article) }) {
            CategoryIcon(category = category)
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = article.title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Medium),
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 2
                )
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

@Composable
private fun CategoryIcon(category: Category) {
    Icon(
        imageVector = ImageVector.vectorResource(id = category.icon()),
        contentDescription = null,
        modifier = Modifier
            .background(category.color(), CircleShape)
            .size(36.dp)
            .padding(6.dp),
        tint = Color.White
    )
}

private fun Category.color() = when (this) {
    Category.business -> BusinessColor
    Category.entertainment -> EntertainmentColor
    Category.general -> GeneralColor
    Category.health -> HealthColor
    Category.science -> ScienceColor
    Category.sports -> SportsColor
    Category.technology -> TechnologyColor
}

private fun Category.icon() = when (this) {
    Category.business -> R.drawable.business
    Category.entertainment -> R.drawable.entertainment
    Category.general -> R.drawable.genaral
    Category.health -> R.drawable.health
    Category.science -> R.drawable.science
    Category.sports -> R.drawable.sports
    Category.technology -> R.drawable.technology
}

@Preview
@Preview(device = Devices.TABLET)
@Composable
fun PreviewListItems(
    @PreviewParameter(ArticlesResourcePreviewParameterProvider::class)
    articles: List<Article>,
) {
    NewsTheme {
        NewsBackground {
            ExplorerList(
                articles =
                articles.asSequence().map { Pair(Category.business, it) }
                    .plus(articles.map { Pair(Category.entertainment, it) })
                    .plus(articles.map { Pair(Category.general, it) })
                    .plus(articles.map { Pair(Category.health, it) })
                    .plus(articles.map { Pair(Category.science, it) })
                    .plus(articles.map { Pair(Category.sports, it) })
                    .plus(articles.map { Pair(Category.technology, it) }).toList()
            ) {}
        }
    }
}