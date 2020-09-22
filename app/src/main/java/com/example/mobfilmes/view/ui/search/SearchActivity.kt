package com.example.mobfilmes.view.ui.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.mobfilmes.MyApplication
import com.example.mobfilmes.R
import com.example.mobfilmes.data.model.Movie
import com.example.mobfilmes.databinding.ActivitySearchBinding
import com.example.mobfilmes.view.adapter.HandlerAdapter
import com.example.mobfilmes.view.adapter.MovieAdapter
import com.example.mobfilmes.view.ui.MainFactory
import com.example.mobfilmes.view.ui.detail.DetailActivity
import com.example.mobfilmes.view.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject


class SearchActivity : AppCompatActivity(), HandlerAdapter {

    private lateinit var recycler: RecyclerView

    private val adapter = MovieAdapter()

    lateinit var searchView: androidx.appcompat.widget.SearchView

    @Inject
    lateinit var factory: MainFactory

    lateinit var viewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDependencyInjection()
        initViewModel()
        initDataBinding()
        setupToolbar()
        initSearchView()
        initRecyclerView()
    }

    private fun setupToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initDependencyInjection() {
        MyApplication.getApplication().getAppComponent().inject(this)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, factory)[SearchViewModel::class.java]
    }

    private fun initDataBinding() {
        val binding = DataBindingUtil
            .setContentView<ActivitySearchBinding>(this, R.layout.activity_search)
        binding.lifecycleOwner = this
    }

    private fun initRecyclerView() {
        recycler = findViewById(R.id.recycler)
        recycler.hasFixedSize()
        recycler.adapter = adapter
        adapter.setHandler(this)
    }

    private fun initSearchView() {
        searchView = findViewById(R.id.search)
        searchView.setOnQueryTextListener(searchListener)
    }

    private val searchListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            if (query != null)
                viewModel.searchMovies(query)
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            return true
        }
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }

    override fun onClickItem(view: View, position: Int, obj: Any) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("id", (obj as Movie).id)
        startActivity(intent)
    }

}