package com.jiyoung.kotilnexample.ui.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.jiyoung.kotilnexample.R
import com.jiyoung.kotilnexample.server.model.Article
import com.jiyoung.kotilnexample.server.model.NewsItemContent
import com.jiyoung.kotilnexample.ui.Log
import com.jiyoung.kotilnexample.ui.base.BaseLiveEvent
import com.jiyoung.kotilnexample.ui.news.nav.NewsAdapterNavigator
import com.jiyoung.kotilnexample.ui.news.vh.NewsItemViewHolder
import com.jiyoung.kotilnexample.ui.news.vm.NewsItemViewModel

class NewsItemBinderAdapter : RecyclerView.Adapter<NewsItemViewHolder>(), NewsAdapterNavigator {
    var titles :ArrayList<String> = arrayListOf()
    var newsItems: ArrayList<NewsItemContent> = arrayListOf()

    val seeAllEvent = BaseLiveEvent<String>()
    val detailEvent = BaseLiveEvent<Article>()
    init {
        Log.e("init")
    }

    fun set(titles : ArrayList<String>, newsItems : ArrayList<NewsItemContent>){
        this.titles = titles
        this.newsItems = newsItems
        notifyDataSetChanged()
    }

    fun add(title : String, newsItems :NewsItemContent){
        this.titles.add(title)
        this.newsItems.add(newsItems)
        notifyDataSetChanged()
    }

    fun clear(){
        this.titles.clear()
        this.newsItems.clear()
    }

    override fun seeAllClicked(query: String) {
        seeAllEvent.value = query
    }

    override fun seeDetailClicked(content: Article) {
        detailEvent.value = content
    }

    override fun getItemCount(): Int = newsItems.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        return NewsItemViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_news_main, parent, false))
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.setNavigator(this)
        holder.bind(titles[position], newsItems[position])
    }
}