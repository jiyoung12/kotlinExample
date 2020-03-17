package com.jiyoung.kotilnexample.ui.news.vm

import androidx.lifecycle.MutableLiveData
import com.jiyoung.kotilnexample.server.model.NewsItemContent
import com.jiyoung.kotilnexample.ui.Log
import com.jiyoung.kotilnexample.ui.base.BaseItemViewModel
import com.jiyoung.kotilnexample.ui.news.adapter.NewsContentBinderAdapter
import com.jiyoung.kotilnexample.ui.news.nav.NewsListItemNavigator
import java.util.*

class NewsItemViewModel : BaseItemViewModel<NewsItemContent, NewsListItemNavigator>() {

    val newsContentBinderAdapter = NewsContentBinderAdapter()
    var title = MutableLiveData<String>()
    var newsContents = MutableLiveData<NewsItemContent>()

    override fun bind(data: NewsItemContent) {

    }

    fun set(title: String, newsContents: NewsItemContent) {
        this.title.value = title.toUpperCase(Locale.getDefault())
        this.newsContents.value = newsContents
        newsContentBinderAdapter.set(newsContents.articles)
    }

    fun seeAllClicked() {
        Log.e("전체보기클릭 ${title.value}")
        title.value?.let {
            getNavigator().seeAllClicked(it)
        }
    }
}