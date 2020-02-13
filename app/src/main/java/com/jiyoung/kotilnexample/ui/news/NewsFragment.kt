package com.jiyoung.kotilnexample.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.jiyoung.kotilnexample.databinding.FragmentNewsBinding
import com.jiyoung.kotilnexample.ui.Log

class NewsFragment : Fragment() {
    private lateinit var binding : FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        binding.rvNewsContents.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rvNewsContents.adapter = NewsBinderAdapter()

        val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.getNews().observe(this, Observer { news ->
            val adapter = binding.rvNewsContents.adapter as NewsBinderAdapter
            adapter.articles = news
            adapter.notifyDataSetChanged()
        })
        return binding.root
    }
}