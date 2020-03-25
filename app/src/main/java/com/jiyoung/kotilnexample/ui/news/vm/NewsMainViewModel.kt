package com.jiyoung.kotilnexample.ui.news.vm

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.jiyoung.kotilnexample.server.RetrofitFactory
import com.jiyoung.kotilnexample.server.model.NewsItemContent
import com.jiyoung.kotilnexample.ui.base.BaseViewModel
import com.jiyoung.kotilnexample.ui.news.adapter.NewsItemBinderAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import io.reactivex.rxkotlin.toObservable


class NewsMainViewModel(application: Application) : BaseViewModel<Any>(application) {
    var refresh = ObservableBoolean(false)
    val titles : ArrayList<String> = arrayListOf()
    val contents : ArrayList<NewsItemContent> = arrayListOf()
    val newsItemAdapter: NewsItemBinderAdapter = NewsItemBinderAdapter()
    var onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        newsItemAdapter.clear()
    }

    val API_KEY = "bb76772383134f96ac5a097ac791774c"
    val networkService = RetrofitFactory.create()

    fun getNews(queries: Array<String>) {
        refresh.set(true)
        titles.clear()
        contents.clear()
        queries.toObservable()
            .flatMap { query ->
                val content: Observable<NewsItemContent> =
                    networkService.getList(query, API_KEY, 1, 10)
                Observable.zip(
                    content,
                    Observable.just(query),
                    BiFunction { t1 :NewsItemContent, t2 : String ->
                        var pair = Pair(t2, t1)
                        pair
                    })
            }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                titles.add(it.first)
                contents.add(it.second)
            },{
                refresh.set(false)
                it.printStackTrace()
            },{
                refresh.set(false)
                newsItemAdapter.set(titles, contents)
            })
    }
}