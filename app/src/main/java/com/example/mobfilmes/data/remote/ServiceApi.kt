package com.example.mobfilmes.data.remote

import com.example.mobfilmes.data.model.Movie
import com.example.mobfilmes.data.model.MovieDetail
import com.example.mobfilmes.data.model.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApi {

    @GET("movie/now_playing")
    fun getListNowPlaying(
        @Query("api_key") key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Single<MovieResponse>

    @GET("movie/{id}")
    fun getMovieDetail(
        @Path("id") id: Int,
        @Query("api_key") key: String,
        @Query("language") language: String
    ): Single<MovieDetail>

    @GET("search/movie")
    fun getSearchMovie(
        @Query("query") query: String,
        @Query("api_key") key: String
    ): Single<MovieResponse>

}