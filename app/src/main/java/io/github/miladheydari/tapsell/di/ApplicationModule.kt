package io.github.miladheydari.tapsell.di


import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.github.miladheydari.tapsell.BuildConfig
import io.github.miladheydari.tapsell.utils.Constants
//import io.github.miladheydari.tapsell.utils.permission.PermissionHandler
import io.github.miladheydari.tapsell.utils.scheduler.SchedulerProvider
import io.github.miladheydari.tapsell.utils.scheduler.SchedulerProviderImpl
import java.io.File
import javax.inject.Singleton


@Module
abstract class ApplicationModule {


    @Binds
    @Singleton

    abstract fun provideAppScheduler(schedulerProvider: SchedulerProviderImpl): SchedulerProvider


    @Module
    companion object {

//        @Provides
//        @Singleton
//        @JvmStatic
//
//        fun providePermissionHandler(): PermissionHandler {
//            return PermissionHandler()
//        }

        @Provides
        @Singleton
        @JvmStatic

        fun provideIsDebug(): Boolean {
            return BuildConfig.DEBUG
        }

        @Provides
        @Singleton
        @JvmStatic

        fun provideNetworkTimeoutInSeconds(): Int {
            return 30
        }


        @Provides
        @Singleton
        @JvmStatic

        fun provideDbApiUrl(): String {
            return Constants.URL

        }


        @Provides
        @Singleton
        @JvmStatic

        fun provideCacheSize(): Long {
            return (10 * 1024 * 1024).toLong() // 10 MB
        }

        @Provides
        @Singleton
        @JvmStatic

        fun provideCacheDir(context: Context): File {
            return context.cacheDir
        }

    }
}
