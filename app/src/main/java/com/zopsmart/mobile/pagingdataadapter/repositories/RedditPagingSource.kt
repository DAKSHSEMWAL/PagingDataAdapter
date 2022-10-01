package com.zopsmart.mobile.pagingdataadapter.repositories

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.zopsmart.mobile.pagingdataadapter.models.RedditPost
import com.zopsmart.mobile.pagingdataadapter.networking.RedditService

class RedditPagingSource(private val redditService: RedditService) :
    PagingSource<String, RedditPost>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, RedditPost> {
        TODO("not implemented")
    }

    override fun getRefreshKey(state: PagingState<String, RedditPost>): String? {
        TODO("Not yet implemented")
    }
}