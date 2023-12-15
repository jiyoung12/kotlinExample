package com.jyhong.domain.repository

/**
 * KotilnExample
 * Class: NewsRepository
 * Created by jiyoung on 2023/12/07.
 *
 * Description:
 */
interface NewsRepository {

    suspend fun getEverything(
        query: String?,
        searchIn: String?,
        from: String, // yyyy-MM-dd
        to: String,  // yyyy-MM-dd
        lang: String,
        sortBy: String,
        page: Int,
        pageSize: Int = 50
    )

    suspend fun getTopHeadlines(
        country: String,
        category: String,
        source: String,
        query: String?,
        page: Int,
        pageSize: Int = 50
    )


    suspend fun getSource(
        category: String,
        lang: String,
        country: String
    )
}