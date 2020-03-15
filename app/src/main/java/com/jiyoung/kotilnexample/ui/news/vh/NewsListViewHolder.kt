package com.jiyoung.kotilnexample.ui.news.vh

import com.jiyoung.kotilnexample.databinding.ItemNewsListBinding
import com.jiyoung.kotilnexample.server.model.Article
import com.jiyoung.kotilnexample.ui.base.BaseViewHolder
import com.jiyoung.kotilnexample.ui.news.vm.NewsListItemViewModel

class NewsListViewHolder(val binding: ItemNewsListBinding) : BaseViewHolder<Any>(binding.root) {
    private val viewModel = NewsListItemViewModel()

    fun bind(article: Article){
        binding.item = viewModel
        viewModel.set(article)
    }
}