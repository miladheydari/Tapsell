package io.github.miladheydari.tapsell.screens.first

import android.arch.lifecycle.MutableLiveData
import io.github.miladheydari.tapsell.repository.db.entities.Note
import io.github.miladheydari.tapsell.repository.managers.note.NoteManager
import io.github.miladheydari.tapsell.utils.base.ViewModel
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class NotesViewModel @Inject constructor(private val noteManager: NoteManager) : ViewModel() {


    val notes: MutableLiveData<List<Note>> = MutableLiveData()

    fun fetchData() {
        loading.value = true
        compositeDisposable?.add(noteManager.getAllNotes().subscribeWith(object :
            DisposableSingleObserver<List<Note>>() {

            override fun onSuccess(t: List<Note>) {
                loading.value = false
                notes.value = t
                error.value = Pair(false, "")

            }

            override fun onError(e: Throwable) {
                error.value = Pair(true, e.message!!)
                loading.value = false
            }
        }))

    }

}