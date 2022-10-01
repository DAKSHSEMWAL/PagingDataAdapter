package com.zopsmart.mobile.pagingdataadapter.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.zopsmart.mobile.pagingdataadapter.models.RedditKeys

@Dao
interface RedditKeysDao {

    @Insert(onConflict = REPLACE)
    suspend fun saveRedditKeys(redditKey: RedditKeys)

    @Query("SELECT * FROM redditKeys ORDER BY id DESC")
    suspend fun getRedditKeys(): List<RedditKeys>

}
