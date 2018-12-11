package io.github.miladheydari.tapsell.di.common


import dagger.Module
import dagger.Provides
import io.github.miladheydari.tapsell.repository.api.Api
import io.github.miladheydari.tapsell.repository.api.RetrofitInterface
import io.github.miladheydari.tapsell.utils.scheduler.SchedulerProvider

import retrofit2.Retrofit
import javax.inject.Singleton

@Module
object ApiModule {

    @JvmStatic
    @Provides
    @Singleton
    fun provideService(retrofitInterface: RetrofitInterface, scheduler: SchedulerProvider): Api {
        return Api(retrofitInterface, scheduler)
    }



        @Provides
        @JvmStatic
        @Singleton
        fun provideApiService(retrofit: Retrofit): RetrofitInterface {

            return retrofit.create(RetrofitInterface::class.java)
        }




}
