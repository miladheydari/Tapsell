package io.github.miladheydari.tapsell.di


import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import io.github.miladheydari.tapsell.Tapsell
import io.github.miladheydari.tapsell.di.common.*

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApiModule::class,
        ActivityBuilder::class,
        AndroidModule::class,
        ApplicationModule::class,
        RetrofitModule::class,
        OkHttpInterceptorModule::class,
        GsonModule::class,
        DbModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {
    fun inject(application: Tapsell)


    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun application(application: Tapsell): Builder
    }
}