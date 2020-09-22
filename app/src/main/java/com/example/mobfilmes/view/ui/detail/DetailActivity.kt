package com.example.mobfilmes.view.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mobfilmes.MyApplication
import com.example.mobfilmes.R
import com.example.mobfilmes.databinding.ActivityDetailBinding
import com.example.mobfilmes.view.ui.MainFactory
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MainFactory

    lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.extras?.getInt("id") as Int
        initDependencyInjection()
        initViewModel(id)
        initDataBinding()
        setupToolbar()
    }

    private fun initDependencyInjection() {
        MyApplication.getApplication().getAppComponent().inject(this)
    }

    private fun initViewModel(id:Int) {
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        viewModel.setMovieId(id)
    }

    private fun initDataBinding() {
        val binding =
            DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun setupToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }

}