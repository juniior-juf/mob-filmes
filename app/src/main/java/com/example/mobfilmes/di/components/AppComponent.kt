package com.example.mobfilmes.di.components

import android.app.Application
import android.content.Context
import com.example.mobfilmes.MyApplication
import com.example.mobfilmes.di.modules.AppModule
import com.example.mobfilmes.di.modules.FactoryModule
import com.example.mobfilmes.view.ui.detail.DetailActivity
import com.example.mobfilmes.view.ui.favorites.FavoriteAct
import com.example.mobfilmes.view.ui.home.HomeAct
import com.example.mobfilmes.view.ui.search.SearchActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, FactoryModule::class])
interface AppComponent {

    fun context(): Context

    fun application(): Application

    fun inject(application: MyApplication)

    fun inject(activity: HomeAct)

    fun inject(activity: DetailActivity)

    fun inject(activity: SearchActivity)

    fun inject(activity: FavoriteAct)
}