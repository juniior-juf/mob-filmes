package com.example.mobfilmes.view.ui.search

import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobfilmes.data.model.Movie
import com.example.mobfilmes.data.model.MovieResponse
import com.example.mobfilmes.data.repository.MovieRepository

class SearchViewModel(@NonNull private val repository: MovieRepository): ViewModel() {

    private val movies = MutableLiveData<List<Movie>>().apply { postValue(arrayListOf()) }

    fun getMovies() = movies

    fun searchMovies(query: String) {
        repository.getSearchMovie(query,
            { res ->
                movies.postValue(res.results)
            }, { error ->
                error.printStackTrace()
            })
    }

    override fun onCleared() {
        repository.clearComposite()
        super.onCleared()
    }


}