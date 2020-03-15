package com.jiyoung.kotilnexample.server

import com.jiyoung.kotilnexample.server.model.NewsItemContent
import com.jiyoung.kotilnexample.server.model.PageListModel
import io.reactivex.Flowable
import io.reactivex.Observable

import java.util.ArrayList

import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("/v2/everything")
    fun getList(
        @Query("q") q: String,
        @Query("apiKey") apiKey: String,
        @Query("page") page: Long,
        @Query("pageSize") pageSize: Int
    ): Observable<NewsItemContent>
}
