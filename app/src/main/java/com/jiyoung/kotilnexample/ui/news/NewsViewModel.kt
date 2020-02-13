package com.jiyoung.kotilnexample.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jiyoung.kotilnexample.server.RetrofitFactory
import com.jiyoung.kotilnexample.server.model.ItemModel
import com.jiyoung.kotilnexample.server.model.PageListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
    val QUERY = "movies"
    val API_KEY = "bb76772383134f96ac5a097ac791774c"
    val networkService = RetrofitFactory.create()

    fun getNews(): MutableLiveData<List<ItemModel>> {
        val liveData = MutableLiveData<List<ItemModel>>()
        networkService.getList(
            QUERY,
            API_KEY,
            1,
            10
        ).enqueue(object : Callback<PageListModel> {
            override fun onFailure(call: Call<PageListModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<PageListModel>, response: Response<PageListModel>) {
                response.body()?.let {
                    liveData.postValue(it.articles)
                }

            }

        })
        return liveData
    }
}