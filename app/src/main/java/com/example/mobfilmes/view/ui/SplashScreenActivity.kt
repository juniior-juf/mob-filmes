package com.example.mobfilmes.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mobfilmes.R
import com.example.mobfilmes.databinding.ActivityMainBinding
import com.example.mobfilmes.view.ui.home.HomeAct

class SplashScreenActivity : AppCompatActivity(), SplashScreenListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
    }

    private fun initDataBinding() {
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.listener = this
    }

    override fun onClick() {
        startActivity(Intent(this, HomeAct::class.java))
    }
}