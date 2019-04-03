package io.github.miladheydari.tapsell.utils.base

import android.arch.lifecycle.MutableLiveData
import io.github.miladheydari.tapsell.repository.db.entities.Note
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

open class ViewModel :android.arch.lifecycle.ViewModel() {
    internal val compositeDisposable: CompositeDisposable? = CompositeDisposable()

    val loading: MutableLiveData<Boolean> = MutableLiveData()
    val error: MutableLiveData<Pair<Boolean, String>> = MutableLiveData()



    override fun onCleared() {
        super.onCleared()

        compositeDisposable?.clear()
    }

}