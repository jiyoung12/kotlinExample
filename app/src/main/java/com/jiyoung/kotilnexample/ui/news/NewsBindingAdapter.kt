package com.jiyoung.kotilnexample.ui.news

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.jiyoung.kotilnexample.AppUtils

@BindingAdapter("bind:publishedAt")
public fun publishedAt(view : TextView, date : String){
    view.text = "${AppUtils.getDate(date)} at ${AppUtils.getTime(date)}"
}

@BindingAdapter("bind:urlToImage")
public fun  urlToImage(view : ImageView, url : String?) {
    url?.let {
        Glide.with(view.context)
            .load(it)
            .into(view)
    }
}

