package com.jiyoung.kotilnexample.ui.base

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.jiyoung.kotilnexample.ui.Log

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    Log.e("set adapter")
    view.adapter = adapter
}

@BindingAdapter(value = ["onRefreshListener", "isRefreshing"], requireAll = false)
fun setOnRefreshListener(
    swipeRefreshLayout: SwipeRefreshLayout,
    onRefreshListener: SwipeRefreshLayout.OnRefreshListener,
    isRefresh: Boolean
) {
    swipeRefreshLayout.setOnRefreshListener(onRefreshListener)
    swipeRefreshLayout.isRefreshing = isRefresh
}