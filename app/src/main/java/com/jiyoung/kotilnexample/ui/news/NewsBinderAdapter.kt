package com.jiyoung.kotilnexample.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jiyoung.kotilnexample.databinding.ItemNewsContentBinding
import com.jiyoung.kotilnexample.server.model.ItemModel

class NewsBinderAdapter() : RecyclerView.Adapter<NewsBinderAdapter.NewsViewHolder>(){
    var articles : List<ItemModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val model = articles[position]
        holder.binding.item = model
    }


        @BindingAdapter("bind:publishedAt")
        public fun publishedAt(view : TextView, date : String){
            view.text = date
        }

        @BindingAdapter("bind:urlToImage")
        public fun  urlToImage(view : ImageView, url : String) {

        }
    class NewsViewHolder(val binding: ItemNewsContentBinding) : RecyclerView.ViewHolder(binding.root)
}