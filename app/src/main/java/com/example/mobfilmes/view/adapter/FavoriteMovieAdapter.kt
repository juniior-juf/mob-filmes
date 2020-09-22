package com.example.mobfilmes.view.adapter

import com.example.mobfilmes.R
import com.example.mobfilmes.data.model.FavoriteMovie
import com.example.mobfilmes.data.model.Movie

class FavoriteMovieAdapter : BaseAdapter() {

    private var movies = emptyList<FavoriteMovie>()
    private lateinit var handler: HandlerAdapter

    fun setItemList(movies: List<FavoriteMovie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    fun setHandler(handler: HandlerAdapter) {
        this.handler = handler
    }

    override fun getObjForPosition(position: Int): Any {
        return movies[position]
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.favorite_movie_item
    }

    override fun getHandler(): HandlerAdapter? {
        return handler
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}