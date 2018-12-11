package io.github.miladheydari.tapsell.di.common

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.github.miladheydari.tapsell.repository.db.TapsellDatabase
import io.github.miladheydari.tapsell.repository.db.daos.NoteDao
import io.github.miladheydari.tapsell.repository.managers.note.INoteManager
import io.github.miladheydari.tapsell.repository.managers.note.NoteManager
import io.github.miladheydari.tapsell.repository.db.repositories.note.INoteRepository
import io.github.miladheydari.tapsell.repository.db.repositories.note.NoteRepository
import javax.inject.Singleton

@Module
abstract class DbModule {


    @Binds
    @Singleton
    abstract fun provideNoteManager(noteManager: NoteManager): INoteManager

    @Binds
    @Singleton
    abstract fun provideNoteRepository(noteRepository: NoteRepository): INoteRepository


    @Module
    companion object {


        @Singleton
        @Provides
        @JvmStatic
        fun provideDao(tapsellDatabase: TapsellDatabase): NoteDao {

            return tapsellDatabase.noteDao()
        }

        @Singleton
        @Provides
        @JvmStatic
        fun provideDb(context: Context): TapsellDatabase {

            return TapsellDatabase.getInstance(context)
        }
    }

}