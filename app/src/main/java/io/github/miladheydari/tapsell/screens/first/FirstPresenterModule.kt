package io.github.miladheydari.tapsell.screens.first

import dagger.Module
import dagger.Provides

@Module
class FirstPresenterModule {
    @Provides
    fun provideFirstPresenter(presenter: FirstPresenter): FirstContract.Presenter = presenter
}
