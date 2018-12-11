package io.github.miladheydari.tapsell.di.common


import android.util.Log

import dagger.Module
import dagger.Provides

import okhttp3.logging.HttpLoggingInterceptor

import javax.inject.Singleton

@Module
object OkHttpInterceptorModule {





    @Singleton
    @Provides
    @JvmStatic
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.d("OkHttp", message) })
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging


    }


}
