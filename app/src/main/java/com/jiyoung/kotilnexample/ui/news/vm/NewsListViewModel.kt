package com.jiyoung.kotilnexample.ui.news.vm

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.jiyoung.kotilnexample.server.RetrofitFactory
import com.jiyoung.kotilnexample.server.model.Article
import com.jiyoung.kotilnexample.ui.base.BaseViewModel
import com.jiyoung.kotilnexample.ui.news.adapter.NewsListBinderAdapter
import com.jiyoung.kotilnexample.ui.news.ds.NewsListDataSourceFactory

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
        // todo 물음표가 너무 많은거같아ㅠㅠ
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