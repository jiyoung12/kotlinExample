package com.jiyoung.kotilnexample.ui.news.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jiyoung.kotilnexample.server.model.NewsItemContent
import com.jiyoung.kotilnexample.ui.Log
import com.jiyoung.kotilnexample.ui.news.adapter.NewsContentBinderAdapter
import java.util.*

class NewsItemViewModel : ViewModel() {
    val newsContentBinderAdapter = NewsContentBinderAdapter()
    var title = MutableLiveData<String>()
    var newsContents = MutableLiveData<NewsItemContent>()

    fun set(title: String, newsContents: NewsItemContent) {
        this.title.value = title.toUpperCase(Locale.getDefault())
        this.newsContents.value = newsContents
        newsContentBinderAdapter.set(newsContents.articles)
    }

    fun seeAllClicked() {
        Log.e("전체보기클릭")
    }
}