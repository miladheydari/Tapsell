package io.github.miladheydari.tapsell.repository.managers.note

import io.github.miladheydari.tapsell.repository.db.entities.Note

import io.github.miladheydari.tapsell.repository.api.Api

import io.github.miladheydari.tapsell.repository.db.repositories.note.INoteRepository
import io.github.miladheydari.tapsell.utils.toEntity
import io.github.miladheydari.tapsell.utils.toModel
import io.reactivex.Observable
import javax.inject.Inject

class NoteManager @Inject constructor(
    private val api: Api,
    private val noteRepository: INoteRepository
) : INoteManager {
    override fun getAllNotes(): Observable<List<Note>> {

        return noteRepository.getAll()

    }

    override fun storeNote(note: Note): Observable<Unit> {


        return api.sendData(note.toModel()).flatMap { noteRepository.insert((it.json.toEntity())) }


    }


}
