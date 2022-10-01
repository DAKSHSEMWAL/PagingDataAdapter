package com.zopsmart.mobile.pagingdataadapter.repositories

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.zopsmart.mobile.pagingdataadapter.models.RedditPost
import com.zopsmart.mobile.pagingdataadapter.networking.RedditService
import retrofit2.HttpException
import java.io.IOException

class RedditPagingSource(private val redditService: RedditService) :
    PagingSource<String, RedditPost>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, RedditPost> =
        try {
            val response = redditService.fetchPosts(loadSize = params.loadSize)
            val listing = response.body()?.data
            val redditPosts = listing?.children?.map { it.data }
            LoadResult.Page(
                redditPosts ?: listOf(),
                listing?.before,
                listing?.after
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }

    override fun getRefreshKey(state: PagingState<String, RedditPost>): String? {
        TODO("Not yet implemented")
    }

    override val keyReuseSupported: Boolean = true
}