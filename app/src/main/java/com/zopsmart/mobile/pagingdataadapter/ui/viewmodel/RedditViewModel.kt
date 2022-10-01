package com.zopsmart.mobile.pagingdataadapter.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.zopsmart.mobile.pagingdataadapter.models.RedditPost
import com.zopsmart.mobile.pagingdataadapter.repositories.RedditRepo
import kotlinx.coroutines.flow.Flow

class RedditViewModel(application: Application) : AndroidViewModel(application) {
    private val redditRepo = RedditRepo(application)

    fun fetchPosts(): Flow<PagingData<RedditPost>> =
        redditRepo.fetchPosts().cachedIn(viewModelScope)
}