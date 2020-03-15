package com.jiyoung.kotilnexample.ui.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jiyoung.kotilnexample.databinding.ItemNewsContentBinding
import com.jiyoung.kotilnexample.server.model.Article
import com.jiyoung.kotilnexample.ui.Log

class NewsContentBinderAdapter : RecyclerView.Adapter<NewsContentBinderAdapter.NewsViewHolder>(){
    var articles : List<Article> = emptyList()

    init {
        Log.e("init")
    }

    fun set(articles : List<Article>){
        this.articles = articles
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val model = articles[position]
        holder.binding.item = model
    }

    class NewsViewHolder(val binding: ItemNewsContentBinding) : RecyclerView.ViewHolder(binding.root)
}
