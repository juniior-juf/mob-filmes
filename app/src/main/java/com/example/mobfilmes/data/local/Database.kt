package com.example.mobfilmes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobfilmes.data.local.dao.MovieDao
import com.example.mobfilmes.data.model.FavoriteMovie

@Database(entities = [FavoriteMovie::class], version = 1)
abstract class DatabaseMob : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    fun clearDB() {
        clearAllTables()
        close()
    }
}