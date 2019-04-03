package io.github.miladheydari.tapsell.repository.managers.note

import io.github.miladheydari.tapsell.repository.db.entities.Note

import io.reactivex.Single

interface INoteManager {
    fun getAllNotes(): Single<List<Note>>
    fun storeNote(note: Note):Single<Unit>

}