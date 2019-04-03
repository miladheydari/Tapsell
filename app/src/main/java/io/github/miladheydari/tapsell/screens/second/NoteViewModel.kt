package io.github.miladheydari.tapsell.screens.second

import android.arch.lifecycle.MutableLiveData
import io.github.miladheydari.tapsell.repository.db.entities.Note
import io.github.miladheydari.tapsell.repository.managers.note.NoteManager
import io.github.miladheydari.tapsell.utils.base.ViewModel
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class NoteViewModel @Inject constructor(private val noteManager: NoteManager) : ViewModel() {


    val success: MutableLiveData<Boolean> = MutableLiveData()


    fun store(note: String) {
        loading.value = true
        compositeDisposable?.add(noteManager.storeNote(Note(note)).subscribeWith(object :
            DisposableSingleObserver<Unit>() {

            override fun onSuccess(t: Unit) {
                loading.value = false
                success.value = true
                error.value = Pair(false, "")

            }

            override fun onError(e: Throwable) {
                loading.value = false
                success.value = false
                error.value = Pair(true, e.message!!)
            }
        }))

    }

}