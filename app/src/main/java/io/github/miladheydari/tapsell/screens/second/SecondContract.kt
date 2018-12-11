package io.github.miladheydari.tapsell.screens.second

import io.github.miladheydari.tapsell.utils.base.IPresenter
import io.github.miladheydari.tapsell.utils.base.IView

class SecondContract {
    interface View : IView<Presenter>
    {
        abstract fun onStore()
    }
    abstract class Presenter : IPresenter<View>(){
        abstract fun store(note:String)
    }
}
