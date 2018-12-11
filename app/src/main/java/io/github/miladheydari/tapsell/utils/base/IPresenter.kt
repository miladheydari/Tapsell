package io.github.miladheydari.tapsell.utils.base

import io.reactivex.disposables.CompositeDisposable

abstract class IPresenter<T> {


    protected val compositeDisposable = CompositeDisposable()

    open fun unsubscribe() {
        compositeDisposable.clear()
    }


    abstract fun attachView(view: T)

}
