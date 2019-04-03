package io.github.miladheydari.tapsell.repository.db.repositories.base

import io.github.miladheydari.tapsell.repository.db.daos.IDao


import io.github.miladheydari.tapsell.utils.scheduler.SchedulerProvider
import io.reactivex.Single

open class RepositoryBase<T>
constructor(private val dao: IDao<T>, private val schedulerProvider: SchedulerProvider) : IRepositoryBase<T> {


    override fun insert(entities: T): Single<Unit> {

        return Single.fromCallable { dao.insert(entities) }.subscribeOn(schedulerProvider.backgroundThread()).observeOn(schedulerProvider.mainThread())

    }


    override fun getList(ids: MutableList<String>): Single<List<T>> {

        return Single.fromCallable { dao.getList(ids) }.subscribeOn(schedulerProvider.backgroundThread()).observeOn(schedulerProvider.mainThread())

    }



    override fun getAll(): Single<List<T>> {

        return Single.fromCallable { dao.getAll() }.subscribeOn(schedulerProvider.backgroundThread()).observeOn(schedulerProvider.mainThread())
    }

    override fun delete(entity: T): Single<Int> {
        return Single.fromCallable { dao.delete(entity) }.subscribeOn(schedulerProvider.backgroundThread()).observeOn(schedulerProvider.mainThread())
    }


}