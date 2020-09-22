package com.example.mobfilmes.di.modules

import com.example.mobfilmes.data.repository.MovieRepositoryImpl
import com.example.mobfilmes.view.ui.MainFactory
import dagger.Module
import dagger.Provides

@Module(includes = [RepositoryModule::class])
class FactoryModule {

    @Provides
    fun provideMainFactory(repository: MovieRepositoryImpl): MainFactory {
        return MainFactory(repository)
    }

}