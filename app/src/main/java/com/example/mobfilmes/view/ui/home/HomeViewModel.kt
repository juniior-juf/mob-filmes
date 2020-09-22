package com.example.mobfilmes.view.ui.home

import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobfilmes.data.model.Movie
import com.example.mobfilmes.data.repository.MovieRepository

class HomeViewModel(@NonNull private val repository: MovieRepository) : ViewModel() {

    private val movies = MutableLiveData<List<Movie>>().apply { postValue(arrayListOf()) }
    private val page = MutableLiveData<Int>()
    private var pageAux = 1

    val loading = MutableLiveData<Boolean>().apply { postValue(true) }

    init {
        page.postValue(pageAux)
        fetchNowMovies(pageAux)
    }

    fun getMovies() = movies

    private fun fetchNowMovies(page: Int) {
        loading.postValue(true)
        repository.getListMoviesNowPlaying(page,
            { res ->
                addMovies(res.results)
                loading.postValue(false)
            }, { error ->
                error.printStackTrace()
                loading.postValue(false)
            })
    }

    private fun addMovies(newMovies: List<Movie>) {
        val listAux = mutableListOf<Movie>()
        movies.value?.let { listAux.addAll(it) }
        listAux.addAll(newMovies)
        movies.postValue(listAux)
    }


    fun loadMoreMovies() {
        pageAux = page.value?.plus(1)!!
        page.postValue(pageAux)
        fetchNowMovies(pageAux)
    }

    override fun onCleared() {
        repository.clearComposite()
        super.onCleared()
    }
}