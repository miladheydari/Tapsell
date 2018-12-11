package io.github.miladheydari.tapsell.repository.db.repositories.base


import io.reactivex.Observable

interface IRepositoryBase<T> {


    fun getAll(): Observable<List<T>>


    fun insert(entities: T): Observable<Unit>


    fun getList(ids: MutableList<String>): Observable<List<T>>

    fun delete(entity: T): Observable<Int>



}