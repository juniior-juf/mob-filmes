package com.example.mobfilmes.di.modules

import com.example.mobfilmes.view.adapter.MovieAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

    @Provides
    fun provideAdapter(): MovieAdapter {
        return MovieAdapter()
    }

}