package io.github.miladheydari.tapsell.repository.db.repositories.base

import io.github.miladheydari.tapsell.repository.db.daos.IDao


import io.github.miladheydari.tapsell.utils.scheduler.SchedulerProvider
import io.reactivex.Observable

open class RepositoryBase<T>
constructor(private val dao: IDao<T>, private val schedulerProvider: SchedulerProvider) : IRepositoryBase<T> {


    override fun insert(entities: T): Observable<Unit> {

        return Observable.fromCallable { dao.insert(entities) }.subscribeOn(schedulerProvider.backgroundThread()).observeOn(schedulerProvider.mainThread())

    }


    override fun getList(ids: MutableList<String>): Observable<List<T>> {

        return Observable.fromCallable { dao.getList(ids) }.subscribeOn(schedulerProvider.backgroundThread()).observeOn(schedulerProvider.mainThread())

    }



    override fun getAll(): Observable<List<T>> {

        return Observable.fromCallable { dao.getAll() }.subscribeOn(schedulerProvider.backgroundThread()).observeOn(schedulerProvider.mainThread())
    }

    override fun delete(entity: T): Observable<Int> {
        return Observable.fromCallable { dao.delete(entity) }.subscribeOn(schedulerProvider.backgroundThread()).observeOn(schedulerProvider.mainThread())
    }


}