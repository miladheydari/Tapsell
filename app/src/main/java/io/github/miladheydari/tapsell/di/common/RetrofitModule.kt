package io.github.miladheydari.tapsell.di.common

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
object RetrofitModule {




    @Provides
    @Singleton
    @JvmStatic

    fun provideDataRetrofit(baseUrl: String, converterFactory: Converter.Factory, callAdapterFactory: CallAdapter.Factory,  okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(callAdapterFactory)
                    .client(okHttpClient)
                    .build()




    @Singleton
    @Provides
    @JvmStatic

    fun provideDbOkHttpClient(loggingInterceptor: HttpLoggingInterceptor,
                              networkTimeoutInSeconds: Int,
                              isDebug: Boolean,
                              cache: Cache): OkHttpClient {


        val okHttpClient = OkHttpClient.Builder()
                .cache(cache)
                .readTimeout(networkTimeoutInSeconds.toLong(), TimeUnit.SECONDS)
                .connectTimeout(networkTimeoutInSeconds.toLong(), TimeUnit.SECONDS)

        if (isDebug)
            okHttpClient.addInterceptor(loggingInterceptor)

        return okHttpClient.build()
    }





    @Provides
    @JvmStatic
    @Singleton

    fun provideDbCache( cacheDir: File,  cacheSize: Long) =
            Cache(File(cacheDir.path, "api-cache"), cacheSize)


    @Provides
    @JvmStatic
    @Singleton
    fun provideRxJavaCallAdapterFactory(): CallAdapter.Factory =
            RxJava2CallAdapterFactory.create()


    @Provides
    @Singleton
    @JvmStatic
    fun provideGsonConverterFactory(gson: Gson): Converter.Factory =
            GsonConverterFactory.create(gson)

}
