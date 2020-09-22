package com.example.mobfilmes.view.adapter

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mobfilmes.MyApplication
import com.example.mobfilmes.data.model.Genre
import com.example.mobfilmes.util.DateUtil
import com.squareup.picasso.Picasso

class DataBindingAdapter {
    companion object {
        private val context: Context = MyApplication.getApplication().getAppComponent().context()

        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(view: ImageView, url: String?) {
            Log.d("JUF", url)
            if (url?.isNotEmpty()!!)
                Picasso.get()
                    .load(url)
                    .fit()
                    .centerCrop()
                    .into(view)
        }

        @BindingAdapter("date")
        @JvmStatic
        fun setDate(view: View, value: String?) {
            if (value != null && value.isNotEmpty()) {
                val newDate = DateUtil.parseToDate(value, DateUtil.PATTERN_2)
                (view as TextView).text = DateUtil.formatDate(newDate, DateUtil.PATTERN_1)
            }
        }

        @BindingAdapter("data")
        @JvmStatic
        fun setData(view: ListView, values: List<Genre>?) {
            if (values != null && values.isNotEmpty()) {
                val list = ArrayList<String>()
                values.forEach { v -> list.add(v.name) }
                val arrayAdapter = ArrayAdapter(context, android.R.layout.simple_gallery_item, list)
                view.adapter = arrayAdapter
            }
        }
    }
}