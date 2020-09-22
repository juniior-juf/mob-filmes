package com.example.mobfilmes.view.ui.home

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
import com.example.mobfilmes.data.model.Movie
import com.example.mobfilmes.databinding.ActivityHomeBinding
import com.example.mobfilmes.view.adapter.HandlerAdapter
import com.example.mobfilmes.view.adapter.MovieAdapter
import com.example.mobfilmes.view.ui.MainFactory
import com.example.mobfilmes.view.ui.detail.DetailActivity
import com.example.mobfilmes.view.ui.favorites.FavoriteAct
import com.example.mobfilmes.view.ui.search.SearchActivity
import javax.inject.Inject

class HomeAct : AppCompatActivity(), HomeListener, HandlerAdapter {

    @BindView(R.id.recycler)
    lateinit var recycler: RecyclerView

    @BindView(R.id.layout_floating)
    lateinit var layoutFloating: LinearLayout

    private val adapter = MovieAdapter()

    @Inject
    lateinit var factory: MainFactory

    lateinit var viewModel: HomeViewModel

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
        viewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]
    }

    private fun initDataBinding() {
        val binding =
            DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
        binding.lifecycleOwner = this
        binding.listener = this
        binding.viewModel = viewModel
    }

    private fun initRecyclerView() {
        recycler = findViewById(R.id.recycler)
        recycler.hasFixedSize()
        recycler.setOnTouchListener(onTouchListener)
        recycler.adapter = adapter
        adapter.setHandler(this)
    }

    override fun onStart() {
        super.onStart()
        observableViewModel()
    }

    @SuppressLint("ClickableViewAccessibility")
    private val onTouchListener = View.OnTouchListener { _, event ->
        layoutFloating.visibility = when (event.action) {
            MotionEvent.ACTION_MOVE -> View.GONE
            else -> View.VISIBLE
        }
        false
    }

    private fun observableViewModel() {
        viewModel.getMovies().observe(this, Observer { data ->
            adapter.setItemList(data)
        })
    }

    override fun onClickItem(view: View, position: Int, obj: Any) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("id", (obj as Movie).id)
        startActivity(intent)
    }

    override fun onClickMyFavorite() {
        startActivity(Intent(this, FavoriteAct::class.java))
    }

    override fun onClickSearch() {
        startActivity(Intent(this, SearchActivity::class.java))
    }


}