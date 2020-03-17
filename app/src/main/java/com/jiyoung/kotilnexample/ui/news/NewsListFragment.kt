package com.jiyoung.kotilnexample.ui.news


import androidx.fragment.app.Fragment
import com.jiyoung.kotilnexample.BR

import com.jiyoung.kotilnexample.R
import com.jiyoung.kotilnexample.databinding.FragmentNewsListBinding
import com.jiyoung.kotilnexample.ui.Log
import com.jiyoung.kotilnexample.ui.base.BaseFragment
import com.jiyoung.kotilnexample.ui.news.vm.NewsListViewModel

/**
 * A simple [Fragment] subclass.
 */
class NewsListFragment : BaseFragment<FragmentNewsListBinding, NewsListViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_news_list
    override fun getViewModel(): Class<NewsListViewModel> = NewsListViewModel::class.java
    override fun getBindingVariable(): Int = BR.vm
    override fun initObserver() {
        Log.e("zzzzzzzz")
    }

}
