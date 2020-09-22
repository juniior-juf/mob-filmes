package com.example.mobfilmes.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mobfilmes.data.model.FavoriteMovie
import com.example.mobfilmes.data.model.Movie
import com.example.mobfilmes.data.model.MovieDetail

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: FavoriteMovie)

    @Delete
    suspend fun deleteMovie(movie: FavoriteMovie)

    @Query("SELECT * FROM favorite_movies")
    fun getAllMovies(): LiveData<List<FavoriteMovie>>

    @Query("SELECT * FROM favorite_movies WHERE id=:id")
    suspend fun getMovieById(id: Int): FavoriteMovie?
}