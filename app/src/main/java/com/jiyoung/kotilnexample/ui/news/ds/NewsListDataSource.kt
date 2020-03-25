package com.jiyoung.kotilnexample.ui.news.ds

import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.jiyoung.kotilnexample.BuildConfig
import com.jiyoung.kotilnexample.server.RetrofitService
import com.jiyoung.kotilnexample.server.model.Article
import com.jiyoung.kotilnexample.ui.Log

/**
 * KotilnExample
 * Class: NewsListDataSource
 * Created by jiyoung on 2020/03/22.
 *
 * Description:
 */
class NewsListDataSource(private val query: String, private val service: RetrofitService) :
    PageKeyedDataSource<Long, Article>() {

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, Article>
    ) {
        Log.e("Initial Loading, count: ${params.requestedLoadSize}")
        val currentPage = 1L
        val nextPage = currentPage + 1
        service.getList(query, BuildConfig.API_KEY, currentPage, params.requestedLoadSize)
            .subscribe {
                Log.e("subscribe")
                callback.onResult(it.articles, null, nextPage)
            }
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, Article>) {
        Log.e("Loading key: ${params.key}, count: ${params.requestedLoadSize}")
        service.getList(query, BuildConfig.API_KEY, params.key, params.requestedLoadSize)
            .subscribe({
                val nextKey = params.key + 1
                callback.onResult(it.articles, nextKey)
            }, {
                it.stackTrace
            })
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, Article>) {
        Log.e("Loading key: ${params.key}, count: ${params.requestedLoadSize}")
    }

}

class NewsListDataSourceFactory(
    val query: String,
    private val networkService: RetrofitService
) : DataSource.Factory<Long, Article>() {

    override fun create(): DataSource<Long, Article> =
        NewsListDataSource(query, networkService)
}