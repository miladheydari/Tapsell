package io.github.miladheydari.tapsell.repository.db.daos

abstract class IDao<T> {


    @JvmSuppressWildcards
    abstract fun insert(entities: T)


    abstract fun getAll(): List<T>

    abstract fun getList(ids: MutableList<String>): List<T>


    abstract fun delete(entity: T): Int


}