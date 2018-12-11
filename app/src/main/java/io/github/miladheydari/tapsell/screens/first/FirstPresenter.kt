package io.github.miladheydari.tapsell.screens.first

import io.github.miladheydari.tapsell.repository.db.entities.Note
import io.github.miladheydari.tapsell.repository.managers.note.INoteManager
import io.reactivex.observers.DisposableObserver

import javax.inject.Inject

class FirstPresenter @Inject constructor(private val noteManager: INoteManager) : FirstContract.Presenter() {
    private var getNoteDisposable: DisposableObserver<List<Note>>? = null

    override fun getNotes() {

        getNoteDisposable?.let { compositeDisposable.remove(it) }
        getNoteDisposable = noteManager.getAllNotes().subscribeWith(object : DisposableObserver<List<Note>>() {
            override fun onComplete() {


            }

            override fun onNext(t: List<Note>) {
                viewLayer.onGetNotes(t)
            }

            override fun onError(e: Throwable) {
                viewLayer.onError(e.message)
            }

        })

        compositeDisposable.addAll(getNoteDisposable!!)

    }

    private lateinit var viewLayer: FirstContract.View


    override fun attachView(view: FirstContract.View) {

        viewLayer = view

    }
}
