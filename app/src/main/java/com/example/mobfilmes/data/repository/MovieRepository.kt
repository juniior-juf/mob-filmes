package com.example.mobfilmes.data.repository

import androidx.lifecycle.LiveData
import com.example.mobfilmes.data.model.FavoriteMovie
import com.example.mobfilmes.data.model.Movie
import com.example.mobfilmes.data.model.MovieDetail
import com.example.mobfilmes.data.model.MovieResponse

interface MovieRepository {

    fun getListMoviesNowPlaying(
        page: Int,
        success: (MovieResponse) -> Unit,
        failed: (Throwable) -> Unit
    )

    fun getMovieDetail(
        id: Int,
        success: (MovieDetail) -> Unit,
        failed: (Throwable) -> Unit
    )

    fun getSearchMovie(
        query: String,
        success: (MovieResponse) -> Unit,
        failed: (Throwable) -> Unit
    )

    suspend fun insertMovie(movie: FavoriteMovie)

    suspend fun deleteMovie(movie: FavoriteMovie)

    fun getAllMovies(): LiveData<List<FavoriteMovie>>

    suspend fun getMovieById(id: Int): FavoriteMovie?

    fun clearComposite()
}