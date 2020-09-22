package com.example.mobfilmes

import android.app.Application
import com.example.mobfilmes.di.components.AppComponent
import com.example.mobfilmes.di.components.DaggerAppComponent
import com.example.mobfilmes.di.modules.AppModule

class MyApplication : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        app = this

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()

        appComponent.inject(this)
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }

    companion object {
        private lateinit var app: MyApplication
        fun getApplication() = app
    }
}