package com.jiyoung.kotilnexample.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.jiyoung.kotilnexample.BR

import com.jiyoung.kotilnexample.R
import com.jiyoung.kotilnexample.databinding.FragmentNewsContentBinding
import com.jiyoung.kotilnexample.ui.base.BaseFragment
import com.jiyoung.kotilnexample.ui.news.vm.NewsContentViewModel

/**
 * A simple [Fragment] subclass.
 */
class NewsContentFragment : BaseFragment<FragmentNewsContentBinding, NewsContentViewModel>() {
    val args : NewsContentFragmentArgs by navArgs()
    override fun getLayoutId(): Int = R.layout.fragment_news_content
    override fun getViewModel(): Class<NewsContentViewModel> = NewsContentViewModel::class.java
    override fun getBindingVariable(): Int = BR.vm
    override fun initObserver() {

    }
}
