package io.github.miladheydari.tapsell.repository.db.daos

import android.arch.persistence.room.*

import io.github.miladheydari.tapsell.repository.db.entities.Note

@Dao
abstract class NoteDao : IDao<Note>() {

    @Query("select * from   note")
    abstract override fun getAll(): List<Note>


    @Query("select * from note where id IN (:ids)")
    abstract override fun getList(ids: MutableList<String>): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override fun insert(entity: Note)



    @Delete
    abstract override fun delete(note: Note): Int


}