package io.github.miladheydari.tapsell.screens.second

import dagger.Module
import dagger.Provides

@Module
class SecondPresenterModule {
    @Provides
    fun provideSecondPresenter(presenter: SecondPresenter): SecondContract.Presenter = presenter
}
