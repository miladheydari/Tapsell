package io.github.miladheydari.tapsell.repository.managers.note

import io.github.miladheydari.tapsell.repository.db.entities.Note

import io.reactivex.Observable

interface INoteManager {
    fun getAllNotes(): Observable<List<Note>>
    fun storeNote(note: Note):Observable<Unit>

}