package com.example.mobfilmes.di.modules

import android.app.Application
import android.content.Context
import androidx.annotation.NonNull
import dagger.Module
import dagger.Provides

@Module
class AppModule(@NonNull private val application: Application) {

    @Provides
    fun provideContext(): Context {
        return application
    }

    @Provides
    fun provideApplication(): Application {
        return application
    }

}