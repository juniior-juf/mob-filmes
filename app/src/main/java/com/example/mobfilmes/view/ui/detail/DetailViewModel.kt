package com.example.mobfilmes.view.ui.detail

import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobfilmes.data.model.FavoriteMovie
import com.example.mobfilmes.data.model.Movie
import com.example.mobfilmes.data.model.MovieDetail
import com.example.mobfilmes.data.repository.MovieRepository
import kotlinx.coroutines.launch

class DetailViewModel(@NonNull private val repository: MovieRepository) : ViewModel() {

    private val movie = MutableLiveData<MovieDetail>().apply { postValue(MovieDetail()) }
    val isFavorite = MutableLiveData<Boolean>().apply { postValue(false) }

    fun getMovie() = movie

    fun setMovieId(id: Int) {
        fetchMovieDetail(id)
        fetchMovieById(id)
    }

    private fun fetchMovieDetail(id: Int) {
        repository.getMovieDetail(id, { res ->
            movie.postValue(res)
        }, { error ->
            error.printStackTrace()
        })
    }

    fun addOrDeleteFavorite() {
        var favorite: FavoriteMovie? = null
        movie.value?.let { it ->
            favorite = FavoriteMovie(
                it.id,
                it.title,
                Movie.baseUrlImage + it.posterPath,
                it.releaseDate,
                it.voteAverage
            )
        }

        if(!isFavorite.value!!) {
            viewModelScope.launch {
                favorite?.let { repository.insertMovie(it) }
                isFavorite.postValue(true)
            }
        } else {
            viewModelScope.launch {
                favorite?.let { repository.deleteMovie(it) }
                isFavorite.postValue(false)
            }
        }


    }

    private fun fetchMovieById(id: Int) {
        viewModelScope.launch {
            val res = repository.getMovieById(id)
            if (res != null)
                isFavorite.postValue(true)

        }
    }

    override fun onCleared() {
        repository.clearComposite()
        super.onCleared()
    }
}