package com.example.mobfilmes.view.ui

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mobfilmes.data.repository.MovieRepository
import com.example.mobfilmes.view.ui.detail.DetailViewModel
import com.example.mobfilmes.view.ui.favorites.FavoriteViewModel
import com.example.mobfilmes.view.ui.home.HomeViewModel
import com.example.mobfilmes.view.ui.search.SearchViewModel
import java.lang.IllegalArgumentException

class MainFactory(@NonNull private val repository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(HomeViewModel::class.java) -> {
                    HomeViewModel(repository)
                }

                isAssignableFrom(DetailViewModel::class.java) -> {
                    DetailViewModel(repository)
                }

                isAssignableFrom(SearchViewModel::class.java) -> {
                    SearchViewModel(repository)
                }

                isAssignableFrom(FavoriteViewModel::class.java) -> {
                    FavoriteViewModel(repository)
                }

                else -> throw IllegalArgumentException("Unknown class")
            }
        } as T
}