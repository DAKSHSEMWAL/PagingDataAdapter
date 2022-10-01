package com.zopsmart.mobile.pagingdataadapter.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.zopsmart.mobile.pagingdataadapter.models.RedditKeys
import com.zopsmart.mobile.pagingdataadapter.models.RedditPost

@Dao
interface RedditPostsDao {

    @Insert(onConflict = REPLACE)
    suspend fun savePosts(redditPosts: List<RedditPost>)

    @Query("SELECT * FROM redditPosts")
    fun getPosts(): PagingSource<Int, RedditPost>

}