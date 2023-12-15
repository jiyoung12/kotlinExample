package com.jiyoung.kotilnexample.ui.news


import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.jiyoung.kotilnexample.BR

import com.jiyoung.kotilnexample.R
import com.jiyoung.kotilnexample.databinding.FragmentNewsListBinding
import com.jiyoung.kotilnexample.ui.Log
import com.jiyoung.kotilnexample.ui.base.BaseFragment
import com.jiyoung.kotilnexample.ui.news.adapter.NewsListBinderAdapter
import com.jiyoung.kotilnexample.ui.news.vm.NewsListViewModel

/**
 * A simple [Fragment] subclass.
 */
class NewsListFragment : BaseFragment<FragmentNewsListBinding, NewsListViewModel>() {
    val args: NewsListFragmentArgs by navArgs()
    override fun getLayoutId(): Int = R.layout.fragment_news_list
    override fun getViewModel(): Class<NewsListViewModel> = NewsListViewModel::class.java
    override fun getBindingVariable(): Int = BR.vm

    override fun initObserver() {
        with(viewModel) {
            query = args.query

            pageLiveData?.observe(this@NewsListFragment, Observer {
//                (rvNewsList.adapter as NewsListBinderAdapter).submitList(it)
                isRefresh.set(false)
            })
        }
    }

}
