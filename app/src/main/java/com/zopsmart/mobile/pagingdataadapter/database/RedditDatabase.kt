package com.zopsmart.mobile.pagingdataadapter.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zopsmart.mobile.pagingdataadapter.common.DataBaseConstants.DATABASE_NAME
import com.zopsmart.mobile.pagingdataadapter.models.RedditKeys
import com.zopsmart.mobile.pagingdataadapter.models.RedditPost

@Database(
    entities = [RedditPost::class, RedditKeys::class],
    version = 1,
    exportSchema = false
)
abstract class RedditDatabase : RoomDatabase() {
    companion object {
        fun create(context: Context): RedditDatabase {
            val databaseBuilder =
                Room.databaseBuilder(context, RedditDatabase::class.java, DATABASE_NAME)
            return databaseBuilder.build()
        }
    }
}