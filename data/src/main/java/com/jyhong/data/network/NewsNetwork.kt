package com.jyhong.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.jyhong.data.BuildConfig
import com.jyhong.data.datasource.NewsNetworkDataSource
import com.jyhong.data.model.NetworkArticle
import com.jyhong.data.model.NetworkSource
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

private interface NewsNetworkApi {
    @GET("/v2/everything")
    suspend fun getEverything(
        @Query("q") q: String?,
        @Query("apiKey") apiKey: String,
        @Query("page") page: Long,
        @Query("pageSize") pageSize: Int
    ): ArticleResponse

    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String?,
        @Query("language") language: String?,
        @Query("category") category: String?,
        @Query("source") source: String?,
        @Query("query") query: String?,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): ArticleResponse

    suspend fun getSource(): SourceResponse

}

@Serializable
private data class ArticleResponse(
    val status: String,
    val totalResults: Long,
    val articles: List<NetworkArticle>
)

@Serializable
private data class SourceResponse(
    val status: String,
    val sources: List<NetworkSource>
)

@Singleton
class NewsNetwork @Inject constructor(
    networkJson: Json,
    okHttpClient: Call.Factory
) : NewsNetworkDataSource {
    private val networkApi = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .callFactory(okHttpClient)
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .build()
        .create(NewsNetworkApi::class.java)

    override suspend fun getEverything(
        q: String?,
        apiKey: String,
        page: Long,
        pageSize: Int
    ): List<NetworkArticle> {
        return networkApi.getEverything(q, apiKey, page, pageSize).articles
    }

    override suspend fun getTopHeadlines(
        country: String?,
        language: String?,
        category: String?,
        source: String?,
        query: String?,
        page: Int,
        pageSize: Int
    ): List<NetworkArticle> {
        return networkApi.getTopHeadlines(
            apiKey = BuildConfig.API_KEY,
            country = country,
            language = language,
            category = category,
            source = source,
            query = query,
            page = page,
            pageSize = pageSize
        ).articles
    }

    override suspend fun getSource(): List<Any> {
        return networkApi.getSource().sources
    }
}

