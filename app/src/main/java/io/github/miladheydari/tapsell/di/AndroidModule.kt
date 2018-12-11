package io.github.miladheydari.tapsell.di


import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import io.github.miladheydari.tapsell.Tapsell
import javax.inject.Singleton

@Module
object AndroidModule {


    @Provides
    @Singleton
    @JvmStatic
    fun provideContext(application: Tapsell): Context {
        return application.applicationContext
    }


    @Provides
    @Singleton
    @JvmStatic
    fun provideResources(application: Tapsell): Resources {
        return application.resources

    }


    @Provides
    @Singleton
    @JvmStatic
    fun provideUserSharedPreferences(application: Tapsell): SharedPreferences {
        return application.getSharedPreferences("tapsell", Context.MODE_PRIVATE)
    }


}
