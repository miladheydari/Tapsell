package io.github.miladheydari.tapsell.repository.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import io.github.miladheydari.tapsell.repository.db.daos.NoteDao

import io.github.miladheydari.tapsell.repository.db.entities.Note

import io.github.miladheydari.tapsell.repository.db.utils.SingletonHolder


@Database(entities = [Note::class], version = 1)
abstract class TapsellDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao



    companion object : SingletonHolder<TapsellDatabase, Context>({
        Room.databaseBuilder(it.applicationContext,
                TapsellDatabase::class.java, "tapsell_database")
                .build()
    })


}