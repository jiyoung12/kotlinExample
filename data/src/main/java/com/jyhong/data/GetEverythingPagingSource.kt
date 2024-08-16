package com.jyhong.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jyhong.data.datasource.NewsNetworkDataSource
import com.jyhong.data.mapper.toModel
import com.jyhong.data.model.NetworkArticle
import com.jyhong.domain.model.Article
import com.jyhong.domain.model.Sort

class GetEverythingPagingSource(
    private val dataSource: NewsNetworkDataSource,
    private val query: String?,
    private val searchIn: String?,
    private val to: String?,
    private val from: String?,
    private val lang: String,
    private val sortBy: Sort
) : PagingSource<Long, Article>() {
    override fun getRefreshKey(state: PagingState<Long, Article>): Long? {
        return null
    }

    override suspend fun load(params: LoadParams<Long>): LoadResult<Long, Article> {
        return try {
            val loadSize = 20
            val page = params.key ?: 1
            val response = dataSource.getEverything(
                query = query,
                searchIn = searchIn,
                from = from,
                to = to,
                lang = lang,
                sortBy = sortBy,
                page = page,
                pageSize = loadSize
            )
            LoadResult.Page(
                data = response.map(NetworkArticle::toModel),
                nextKey = if (response.isEmpty()) null else page + 1,
                prevKey = if (page == 1L) null else page - 1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }
}