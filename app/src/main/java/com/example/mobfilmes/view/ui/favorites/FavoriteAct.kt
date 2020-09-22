package com.example.mobfilmes.view.ui.favorites

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.mobfilmes.MyApplication
import com.example.mobfilmes.R
import com.example.mobfilmes.data.model.FavoriteMovie
import com.example.mobfilmes.data.model.Movie
import com.example.mobfilmes.databinding.ActivityFavoriteBinding
import com.example.mobfilmes.databinding.ActivityHomeBinding
import com.example.mobfilmes.view.adapter.FavoriteMovieAdapter
import com.example.mobfilmes.view.adapter.HandlerAdapter
import com.example.mobfilmes.view.adapter.MovieAdapter
import com.example.mobfilmes.view.ui.MainFactory
import com.example.mobfilmes.view.ui.detail.DetailActivity
import com.example.mobfilmes.view.ui.search.SearchActivity
import javax.inject.Inject

class FavoriteAct : AppCompatActivity(), HandlerAdapter {

    @BindView(R.id.recycler)
    lateinit var recycler: RecyclerView

    private val adapter = FavoriteMovieAdapter()

    @Inject
    lateinit var factory: MainFactory

    lateinit var viewModel: FavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDependencyInjection()
        initViewModel()
        initDataBinding()
        initRecyclerView()
        ButterKnife.bind(this)
    }

    private fun initDependencyInjection() {
        MyApplication.getApplication().getAppComponent().inject(this)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
    }

    private fun initDataBinding() {
        val binding =
            DataBindingUtil.setContentView<ActivityFavoriteBinding>(
                this,
                R.layout.activity_favorite
            )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun initRecyclerView() {
        recycler = findViewById(R.id.recycler)
        recycler.hasFixedSize()
        recycler.adapter = adapter
        adapter.setHandler(this)
    }

    override fun onStart() {
        super.onStart()
        observableViewModel()
    }

    private fun observableViewModel() {
        viewModel.getMovies().observe(this, Observer { data ->
            adapter.setItemList(data)
        })
    }

    override fun onClickItem(view: View, position: Int, obj: Any) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("id", (obj as FavoriteMovie).id)
        startActivity(intent)
    }


}