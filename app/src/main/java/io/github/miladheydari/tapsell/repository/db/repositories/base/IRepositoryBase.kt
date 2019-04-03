package io.github.miladheydari.tapsell.repository.db.repositories.base


import io.reactivex.Single

interface IRepositoryBase<T> {


    fun getAll(): Single<List<T>>


    fun insert(entities: T): Single<Unit>


    fun getList(ids: MutableList<String>): Single<List<T>>

    fun delete(entity: T): Single<Int>



}