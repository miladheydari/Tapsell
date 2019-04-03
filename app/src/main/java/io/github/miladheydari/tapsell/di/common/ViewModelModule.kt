package io.github.miladheydari.tapsell.di.common

import io.github.miladheydari.tapsell.utils.ViewModelFactory
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import android.arch.lifecycle.ViewModel
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.miladheydari.tapsell.di.util.ViewModelKey
import io.github.miladheydari.tapsell.screens.first.NotesViewModel
import io.github.miladheydari.tapsell.screens.second.NoteViewModel


@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(NotesViewModel::class)
    abstract fun bindNotesViewModel(notesViewModel: NotesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NoteViewModel::class)
    abstract fun bindNoteViewModel(noteViewModel: NoteViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}