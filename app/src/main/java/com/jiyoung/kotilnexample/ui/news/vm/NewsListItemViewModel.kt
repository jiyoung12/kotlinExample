package com.jiyoung.kotilnexample.ui.news.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jiyoung.kotilnexample.server.model.Article
import com.jiyoung.kotilnexample.ui.Log

class NewsListItemViewModel :ViewModel(){
    var article = MutableLiveData<Article>()

    fun set(article: Article){
        this.article.value = article
    }
    fun seeDetailClicked(){
        Log.e("상세보기")
    }
}