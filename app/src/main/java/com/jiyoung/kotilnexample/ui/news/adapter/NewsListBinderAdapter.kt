package com.jiyoung.kotilnexample.ui.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jiyoung.kotilnexample.R
import com.jiyoung.kotilnexample.server.model.Article
import com.jiyoung.kotilnexample.ui.news.vh.NewsListViewHolder

class NewsListBinderAdapter : RecyclerView.Adapter<NewsListViewHolder>() {
    var articles: List<Article> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder =
        NewsListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_news_list,
                parent,
                false
            )
        )

    override fun getItemCount(): Int =
        articles.size

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        val model = articles[position]
        holder.bind(model)
    }

}