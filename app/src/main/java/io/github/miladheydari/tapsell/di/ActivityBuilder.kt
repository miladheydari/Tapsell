package io.github.miladheydari.tapsell.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.miladheydari.tapsell.screens.first.FirstActivity
import io.github.miladheydari.tapsell.screens.second.SecondActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindFirstActivity(): FirstActivity
    @ContributesAndroidInjector
    abstract fun bindSecondActivity(): SecondActivity

}