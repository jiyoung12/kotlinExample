package com.jiyoung.kotilnexample.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jiyoung.kotilnexample.ui.NewsBackground
import com.jiyoung.kotilnexample.ui.NewsTheme

@Composable
fun Top(
    title: String? = null,
    rightContent: (@Composable RowScope.() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title ?: "",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.weight(1f)
        )
        rightContent?.let { it() }
    }
}


@Composable
@Preview()
private fun PreviewTops() {
    NewsTheme {
        NewsBackground {
            Top("Today") {
                Icon(imageVector = Icons.Default.Settings, contentDescription = null)
            }
        }
    }
}