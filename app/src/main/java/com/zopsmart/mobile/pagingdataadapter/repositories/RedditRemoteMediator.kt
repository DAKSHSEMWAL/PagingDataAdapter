package com.zopsmart.mobile.pagingdataadapter.repositories

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.zopsmart.mobile.pagingdataadapter.database.RedditDatabase
import com.zopsmart.mobile.pagingdataadapter.models.RedditPost
import com.zopsmart.mobile.pagingdataadapter.networking.RedditService

@OptIn(ExperimentalPagingApi::class)
class RedditRemoteMediator(
    private val redditService: RedditService,
    private val redditDatabase: RedditDatabase
) : RemoteMediator<Int, RedditPost>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, RedditPost>
    ): MediatorResult {
        TODO("not implemented")
    }
}