package io.github.miladheydari.tapsell

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.github.miladheydari.tapsell.di.DaggerApplicationComponent
import io.github.miladheydari.tapsell.di.ApplicationComponent
import javax.inject.Inject

class Tapsell : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {

        return dispatchingActivityInjector
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder()
                .application(this)
                .build()

        component?.inject(this)


    }

    companion object {


        var component: ApplicationComponent? = null
            private set
    }
}