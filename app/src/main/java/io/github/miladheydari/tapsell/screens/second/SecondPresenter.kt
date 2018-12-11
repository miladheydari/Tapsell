package io.github.miladheydari.tapsell.screens.second

import io.github.miladheydari.tapsell.repository.db.entities.Note
import io.github.miladheydari.tapsell.repository.db.repositories.note.INoteRepository
import io.github.miladheydari.tapsell.repository.db.repositories.note.NoteRepository
import io.github.miladheydari.tapsell.repository.managers.note.INoteManager
import io.github.miladheydari.tapsell.utils.toEntity
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver

import javax.inject.Inject
import kotlin.random.Random

class SecondPresenter @Inject constructor(
    private val noteManager: INoteManager,
    private val noteRepository: INoteRepository
) :
    SecondContract.Presenter() {
    private var storeDisposable: Disposable? = null

    override fun store(note: String) {


        storeDisposable = noteManager.storeNote(Note(note))
            .subscribeWith(object : DisposableObserver<Unit>() {
                override fun onComplete() {


                }

                override fun onNext(t: Unit) {

                    viewLayer.onStore()

                }

                override fun onError(e: Throwable) {

                    viewLayer.onError(e.message)
                }
            })

        compositeDisposable.addAll(storeDisposable!!)

    }

    private lateinit var viewLayer: SecondContract.View


    override fun attachView(view: SecondContract.View) {
        viewLayer = view
    }

}