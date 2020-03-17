package com.jiyoung.kotilnexample.ui.news.vh

import com.jiyoung.kotilnexample.databinding.ItemNewsMainBinding
import com.jiyoung.kotilnexample.server.model.Article
import com.jiyoung.kotilnexample.server.model.NewsItemContent
import com.jiyoung.kotilnexample.ui.base.BaseViewHolder
import com.jiyoung.kotilnexample.ui.news.nav.NewsAdapterNavigator
import com.jiyoung.kotilnexample.ui.news.nav.NewsListItemNavigator
import com.jiyoung.kotilnexample.ui.news.vm.NewsItemViewModel

class NewsItemViewHolder(val binding: ItemNewsMainBinding) : BaseViewHolder<NewsAdapterNavigator>(binding.root), NewsListItemNavigator {
    private val viewModel = NewsItemViewModel()

    fun bind(title: String, newsContent: NewsItemContent) {
        viewModel.setNavigator(this)
        binding.viewModel = viewModel
        viewModel.set(title, newsContent)

    }

    override fun seeDetailClicked(content: Article) {
        getNavigator().seeDetailClicked(content)
    }

    override fun seeAllClicked(query: String) {
        getNavigator().seeAllClicked(query)
    }

}