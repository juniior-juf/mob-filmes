package com.example.mobfilmes.view.ui.favorites

import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mobfilmes.data.repository.MovieRepository

class FavoriteViewModel(@NonNull private val repository: MovieRepository) : ViewModel() {

    private val movies = repository.getAllMovies()

    fun getMovies() = movies

    override fun onCleared() {
        repository.clearComposite()
        super.onCleared()
    }
}