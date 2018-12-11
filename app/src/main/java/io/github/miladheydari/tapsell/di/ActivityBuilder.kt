package io.github.miladheydari.tapsell.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.miladheydari.tapsell.screens.first.FirstActivity
import io.github.miladheydari.tapsell.screens.first.FirstPresenterModule
import io.github.miladheydari.tapsell.screens.second.SecondActivity
import io.github.miladheydari.tapsell.screens.second.SecondPresenterModule

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [FirstPresenterModule::class])
    abstract fun bindFirstActivity(): FirstActivity
    @ContributesAndroidInjector(modules = [SecondPresenterModule::class])
    abstract fun bindSecondActivity(): SecondActivity

}