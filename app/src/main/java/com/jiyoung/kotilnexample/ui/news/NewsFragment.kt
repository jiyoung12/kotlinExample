package com.jiyoung.kotilnexample.ui.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.jiyoung.kotilnexample.databinding.FragmentNewsBinding
import com.jiyoung.kotilnexample.server.RetrofitFactory
import com.jiyoung.kotilnexample.server.model.PageListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsFragment : Fragment() {
    private lateinit var binding : FragmentNewsBinding
    private val API_KEY = "bb76772383134f96ac5a097ac791774c"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        binding.rvNewsContents.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rvNewsContents.adapter = NewsBinderAdapter()
        getNewsList()
        return binding.root
    }

    fun getNewsList() {
        val retrofitService = RetrofitFactory.create()
        retrofitService.getList("movies", API_KEY, 1, 10)
            .enqueue(object : Callback<PageListModel> {
                override fun onFailure(call: Call<PageListModel>, t: Throwable) {
                    Log.e("TAG", "error {$t.message}")
                }

                override fun onResponse(
                    call: Call<PageListModel>,
                    response: Response<PageListModel>
                ) {
                    if (response.isSuccessful){

                        Log.e("TAG", "Successe")
                        response.body()?.articles?.let {
                            val adapter = binding.rvNewsContents.adapter as NewsBinderAdapter
                            adapter.articles = it
                            adapter.notifyDataSetChanged()
                        }
                    }
                }
            })
    }
}