package com.jiyoung.kotilnexample.ui.news

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.jiyoung.kotilnexample.BR
import com.jiyoung.kotilnexample.R
import com.jiyoung.kotilnexample.databinding.FragmentNewsBinding
import com.jiyoung.kotilnexample.ui.Log
import com.jiyoung.kotilnexample.ui.base.BaseFragment
import com.jiyoung.kotilnexample.ui.news.vm.NewsMainViewModel

class NewsMainFragment : BaseFragment<FragmentNewsBinding, NewsMainViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_news
    override fun getViewModel(): Class<NewsMainViewModel> = NewsMainViewModel::class.java
    override fun getBindingVariable(): Int = BR.vm

    override fun initObserver() {
        with(viewModel) {
            getNews(resources.getStringArray(R.array.query))

            newsItemAdapter.seeAllEvent.observe(this@NewsMainFragment, Observer {
                Log.e("seeAllEvent $it")
                findNavController().navigate(R.id.action_nav_news_to_newsListFragment)
            })

            newsItemAdapter.detailEvent.observe(this@NewsMainFragment, Observer {
                Log.e("detailEvent")
            })
        }
    }

    private fun init() {
        viewModel.onRefreshListener = SwipeRefreshLayout.OnRefreshListener {
            with(viewModel) {
                newsItemAdapter.clear()
                viewModel.getNews(resources.getStringArray(R.array.query))
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
}