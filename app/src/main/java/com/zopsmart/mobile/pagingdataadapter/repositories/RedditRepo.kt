package com.zopsmart.mobile.pagingdataadapter.repositories

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zopsmart.mobile.pagingdataadapter.database.RedditDatabase
import com.zopsmart.mobile.pagingdataadapter.models.RedditPost
import com.zopsmart.mobile.pagingdataadapter.networking.RedditClient
import com.zopsmart.mobile.pagingdataadapter.networking.RedditService
import kotlinx.coroutines.flow.Flow

class RedditRepo(context: Context) {

    private val redditService = RedditClient.getClient().create(RedditService::class.java)

    private val redditDatabase = RedditDatabase.create(context)

    @OptIn(ExperimentalPagingApi::class)
    fun fetchPosts(): Flow<PagingData<RedditPost>> =
        Pager(
            PagingConfig(
                pageSize = 40,
                enablePlaceholders = false,
                prefetchDistance = 3
            ),
            remoteMediator = RedditRemoteMediator(redditService, redditDatabase),
            pagingSourceFactory = { redditDatabase.redditPostsDao().getPosts() }
        ).flow

}