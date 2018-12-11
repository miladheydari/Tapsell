package io.github.miladheydari.tapsell.screens.first

import io.github.miladheydari.tapsell.repository.db.entities.Note
import io.github.miladheydari.tapsell.utils.base.IPresenter
import io.github.miladheydari.tapsell.utils.base.IView

class FirstContract {
    interface View : IView<Presenter> {
        fun onGetNotes(t: List<Note>)
    }

    abstract class Presenter : IPresenter<View>() {

       abstract fun getNotes()
    }
}
