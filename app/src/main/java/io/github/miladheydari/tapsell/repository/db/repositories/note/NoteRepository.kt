package io.github.miladheydari.tapsell.repository.db.repositories.note


import io.github.miladheydari.tapsell.repository.db.entities.Note
import io.github.miladheydari.tapsell.repository.db.repositories.base.RepositoryBase

import io.github.miladheydari.tapsell.repository.db.daos.NoteDao
import io.github.miladheydari.tapsell.utils.scheduler.SchedulerProvider
import javax.inject.Inject

class NoteRepository
@Inject constructor(private val dao: NoteDao, private val schedulerProvider: SchedulerProvider) : INoteRepository, RepositoryBase<Note>(dao, schedulerProvider) {

}


