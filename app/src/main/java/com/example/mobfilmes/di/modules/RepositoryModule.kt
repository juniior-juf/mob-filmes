package com.example.mobfilmes.di.modules

import com.example.mobfilmes.data.local.dao.MovieDao
import com.example.mobfilmes.data.remote.ServiceApi
import com.example.mobfilmes.data.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class, DatabaseModule::class] )
class RepositoryModule {

    @Provides
    fun provideUserRepository(api: ServiceApi, dao:MovieDao): MovieRepositoryImpl {
        return MovieRepositoryImpl(api, dao)
    }
}