package com.jiyoung.kotilnexample.ui.news.vh

import com.jiyoung.kotilnexample.databinding.ItemNewsMainBinding
import com.jiyoung.kotilnexample.server.model.NewsItemContent
import com.jiyoung.kotilnexample.ui.base.BaseViewHolder
import com.jiyoung.kotilnexample.ui.news.vm.NewsItemViewModel

class NewsItemViewHolder(val binding: ItemNewsMainBinding) : BaseViewHolder<Any>(binding.root) {
    private val viewModel = NewsItemViewModel()

    fun bind(title: String, newsContent: NewsItemContent) {
        binding.viewModel = viewModel
        viewModel.set(title, newsContent)
    }
}