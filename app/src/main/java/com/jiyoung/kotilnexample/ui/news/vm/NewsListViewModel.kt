package com.jiyoung.kotilnexample.ui.news.vm

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.jiyoung.kotilnexample.server.RetrofitFactory
import com.jiyoung.kotilnexample.server.model.Article
import com.jiyoung.kotilnexample.server.model.NewsItemContent
import com.jiyoung.kotilnexample.ui.Log
import com.jiyoung.kotilnexample.ui.base.BaseLiveEvent
import com.jiyoung.kotilnexample.ui.base.BaseViewModel
import com.jiyoung.kotilnexample.ui.news.adapter.NewsListBinderAdapter
import com.jiyoung.kotilnexample.ui.news.ds.NewsListDataSource
import com.jiyoung.kotilnexample.ui.news.ds.NewsListDataSourceFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsListViewModel(application: Application) : BaseViewModel<Any>(application) {
    var isRefresh = ObservableBoolean(false)
    val newsListAdapter: NewsListBinderAdapter = NewsListBinderAdapter()
    var pageLiveData: LiveData<PagedList<Article>>? = null
    var query: String = ""
        set(value) {
            field = value
            initPageList()
        }

    var onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        isRefresh.set(true)
        pageLiveData?.value?.dataSource?.invalidate()

    }
    val networkService = RetrofitFactory.create()

    private fun initPageList(){
        val config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(20)
            .setPageSize(10)
            .setPrefetchDistance(5)
            .setEnablePlaceholders(false)
            .build()

        val builder = NewsListDataSourceFactory(query, networkService)
        pageLiveData = LivePagedListBuilder(builder, config).build()
    }

}