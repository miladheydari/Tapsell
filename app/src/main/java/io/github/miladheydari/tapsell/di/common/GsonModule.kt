package io.github.miladheydari.tapsell.di.common

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializer

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import java.math.BigDecimal

@Module
object GsonModule {
    @Singleton
    @Provides
    @JvmStatic
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(Double::class.java, JsonSerializer<Double> { value, _, _ ->
            JsonPrimitive(BigDecimal(value!!).setScale(10,
                    BigDecimal.ROUND_HALF_UP))
        })

        gsonBuilder.setDateFormat("MM/dd/yyyy hh:mm:ss a")
        return gsonBuilder.create()
    }
}
