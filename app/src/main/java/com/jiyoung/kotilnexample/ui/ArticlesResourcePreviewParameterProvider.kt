package com.jiyoung.kotilnexample.ui

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.jiyoung.kotilnexample.ui.ArticlesPreview.articles
import com.jyhong.domain.model.Article
import com.jyhong.domain.model.Source

class ArticlesResourcePreviewParameterProvider : PreviewParameterProvider<List<Article>> {
    override val values: Sequence<List<Article>>
        get() = sequenceOf(articles)
}

object ArticlesPreview {

    val articles = listOf(
        Article(
            author = "TVCHOSUN - TV조선",
            title = "체내 산성도 관리를 통해 건강을 되찾은 그녀들의 비책✨ TV CHOSUN 240811 방송 | [질병의 법칙] 13회 | TV조선",
            description = null,
            url = "https://news.google.com/rss/articles/CCAiC0dkdG1IaU5TNmZNmAEB?oc=5",
            urlToImage = null,
            publishedAt = "2024-08-11T08:04:56Z",
            content = null,
            source = Source(id = "google-news", name = "Google News")
        ),
        Article(
            author = "헬스조선",
            title = "아내 '이 암'으로 보냈는데, 자신까지… 영국 60대 남성 사연 보니? - 헬스조선",
            description = null,
            url = "https://news.google.com/rss/articles/CBMidkFVX3lxTE5VR2paQzZvcXE5ZEVBeHduNV9vTnVfVk9GSlFzVGJhWGNKQ0lfRzRWRmc2cjlfNkhGdHQ4RHcwa2haTzFzTEZuQzZrY0ttRVA1TENhVFhGR0VHNEZwa1VrS3ZxM3YtRC0zQW1UcDU5N0FiNHBXV3c?oc=5",
            urlToImage = null,
            publishedAt = "2024-08-11T08:00:00Z",
            content = null,
            source = Source(id = "google-news", name = "Google News")
        ),
        Article(
            author = "메디컬투데이",
            title = "제2형 당뇨병 환자의 높은 골절률, 골밀도 아닌 낮은 신체 활동 때문 - 메디컬투데이",
            description = null,
            url = "https://news.google.com/rss/articles/CBMiYkFVX3lxTFA5M0s0STRublFBYl9fUjN1Tl8xNXRXUWwzRmFzLTRvUmpGa1g0MzJPZG56QXZRbnBLc0dON0tFRFcxbDNaSlNtM2prYzAtZlo3OW9uZlZfTW1pTmYwVmNvcHJR0gFsQVVfeXFMTzdZNERNYXdwenQ5TDNablFBNldyS2QweHN4UVowdUxENkM4cHFoUzRlWDBnN2s0N3JTVk12RFFaVWVJR2lQanZvMGFCRlc0T2xEYkhKMERtRFpMU3J0S0E5aXB5ZnQtZkg1V1I5?oc=5",
            urlToImage = null,
            publishedAt = "2024-08-11T07:25:21Z",
            content = null,
            source = Source(id = "google-news", name = "Google News")
        )
    )
}