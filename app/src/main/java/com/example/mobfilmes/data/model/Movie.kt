package com.example.mobfilmes.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

class Movie {
    companion object {
        const val columnPopularity = "popularity"
        const val columnVoteCount = "vote_count"
        const val columnVideo = "video"
        const val columnPosterPath = "poster_path"
        const val columnId = "id"
        const val columnAdult = "adult"
        const val columnBackdropPath = "backdrop_path"
        const val columnOriginalLanguage = "original_language"
        const val columnOriginalTitle = "original_title"
        const val columnGenreIds = "genre_ids"
        const val columnTitle = "title"
        const val columnVoteAverage = "vote_average"
        const val columnOverview = "overview"
        const val columnReleaseDate = "release_date"
        const val baseUrlImage = "https://image.tmdb.org/t/p/w500"
    }

    @SerializedName(columnPopularity)
    private var _popularity = 0.0
    var popularity: Double
        get() = _popularity
        set(value) {
            _popularity = value
        }

    @SerializedName(columnVoteCount)
    private var _voteCount = 0
    var voteCount: Int
        get() = _voteCount
        set(value) {
            _voteCount = value
        }

    @SerializedName(columnVideo)
    private var _video = false
    var video: Boolean
        get() = _video
        set(value) {
            _video = value
        }

    @SerializedName(columnPosterPath)
    private var _posterPath = ""
    var posterPath: String
        get() = _posterPath
        set(value) {
            _posterPath = value
        }

    @SerializedName(columnId)
    private var _id = 0
    var id: Int
        get() = _id
        set(value) {
            _id = value
        }

    @SerializedName(columnAdult)
    private var _adult = false
    var adult: Boolean
        get() = _adult
        set(value) {
            _adult = value
        }

    @SerializedName(columnBackdropPath)
    private var _backdropPath = ""
    var backdropPath: String
        get() = _backdropPath
        set(value) {
            _backdropPath = value
        }

    @SerializedName(columnOriginalLanguage)
    private var _originalLanguage = ""
    var originalLanguage: String
        get() = _originalLanguage
        set(value) {
            _originalLanguage = value
        }

    @SerializedName(columnOriginalTitle)
    private var _originalTitle = ""
    var originalTitle: String
        get() = _originalTitle
        set(value) {
            _originalTitle = value
        }

    @SerializedName(columnGenreIds)
    private var _genreIds = arrayListOf<Int>()
    var genreIds: ArrayList<Int>
        get() = _genreIds
        set(value) {
            _genreIds = value
        }

    @SerializedName(columnTitle)
    private var _title = ""
    var title: String
        get() = _title
        set(value) {
            _title = value
        }

    @SerializedName(columnVoteAverage)
    private var _voteAverage = 0F
    var voteAverage: Float
        get() = _voteAverage
        set(value) {
            _voteAverage = value
        }

    @SerializedName(columnOverview)
    private var _overview = ""
    var overview: String
        get() = _overview
        set(value) {
            _overview = value
        }

    @SerializedName(columnReleaseDate)
    private var _releaseDate = ""
    var releaseDate: String
        get() = _releaseDate
        set(value) {
            _releaseDate = value
        }
}