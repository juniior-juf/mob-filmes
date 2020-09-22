package com.example.mobfilmes.di.modules

import android.app.Application
import androidx.room.Room
import com.example.mobfilmes.data.local.DatabaseMob
import com.example.mobfilmes.data.local.dao.MovieDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    companion object {
        private const val DB_NAME = "mob_filmes"
    }

    private lateinit var db: DatabaseMob

    @Singleton
    @Provides
    fun provideDatabase(application: Application): DatabaseMob {
        db = Room.databaseBuilder(
            application,
            DatabaseMob::class.java,
            DB_NAME
        ).build()
        return db
    }

    @Singleton
    @Provides
    fun provideMovieDao(db: DatabaseMob): MovieDao {
        return db.movieDao()
    }
}