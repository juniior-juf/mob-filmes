package com.example.mobfilmes.data.repository

import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import com.example.mobfilmes.data.local.dao.MovieDao
import com.example.mobfilmes.data.model.FavoriteMovie
import com.example.mobfilmes.data.model.Movie
import com.example.mobfilmes.data.model.MovieDetail
import com.example.mobfilmes.data.model.MovieResponse
import com.example.mobfilmes.data.remote.ServiceApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MovieRepositoryImpl(
    @NonNull private val api: ServiceApi,
    @NonNull private val dao: MovieDao
) : MovieRepository {

    private val composite = CompositeDisposable()
    private val apiKey = "8505672ee4102ab7cdec013eb8ee62c8"
    private val language = "pt-BR"

    override fun getListMoviesNowPlaying(
        page: Int,
        success: (MovieResponse) -> Unit,
        failed: (Throwable) -> Unit
    ) {
        val disposable = api.getListNowPlaying(apiKey, language, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ res ->
                success(res)
            }, { error ->
                failed(error)
            })
        composite.add(disposable)
    }

    override fun getMovieDetail(
        id: Int,
        success: (MovieDetail) -> Unit,
        failed: (Throwable) -> Unit
    ) {
        val disposable = api.getMovieDetail(id, apiKey, language)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ res ->
                success(res)
            }, { error ->
                failed(error)
            })

        composite.add(disposable)
    }

    override fun getSearchMovie(
        query: String,
        success: (MovieResponse) -> Unit,
        failed: (Throwable) -> Unit
    ) {
        val disposable = api.getSearchMovie(query, apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ res ->
                success(res)
            }, { error ->
                failed(error)
            })

        composite.add(disposable)
    }

    override suspend fun insertMovie(movie: FavoriteMovie) {
        dao.insertMovie(movie)
    }

    override suspend fun deleteMovie(movie: FavoriteMovie) {
        dao.deleteMovie(movie)    }

    override fun getAllMovies(): LiveData<List<FavoriteMovie>> {
        return dao.getAllMovies()
    }

    override suspend fun getMovieById(id: Int): FavoriteMovie? {
        return dao.getMovieById(id)
    }

    override fun clearComposite() {
        composite.clear()
    }
}