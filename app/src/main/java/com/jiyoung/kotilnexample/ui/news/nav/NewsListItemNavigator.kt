package com.jiyoung.kotilnexample.ui.news.nav

import com.jiyoung.kotilnexample.server.model.Article

interface NewsListItemNavigator {
    fun seeAllClicked(query: String)
    fun seeDetailClicked(content: Article)
}