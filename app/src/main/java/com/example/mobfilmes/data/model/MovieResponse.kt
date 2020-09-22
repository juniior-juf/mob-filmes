package com.example.mobfilmes.data.model

import com.google.gson.annotations.SerializedName

class MovieResponse {
    companion object {
        const val columnResults = "results"
    }

    @SerializedName(columnResults)
    private var _results = arrayListOf<Movie>()
    var results: List<Movie>
        get() = _results
        set(value) {
            _results.addAll(value)
        }
}