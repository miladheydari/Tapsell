package io.github.miladheydari.tapsell.repository.api

import io.github.miladheydari.tapsell.repository.api.model.NoteModel
import io.github.miladheydari.tapsell.repository.api.model.Response
import io.github.miladheydari.tapsell.utils.scheduler.SchedulerProvider
import io.reactivex.Observable
import retrofit2.http.Body

class Api(private val api: RetrofitInterface, private val schedulerProvider: SchedulerProvider) {

    fun sendData(@Body data: NoteModel): Observable<Response> = api.sendData(data).observeOn(schedulerProvider.mainThread()).subscribeOn(schedulerProvider.backgroundThread())


}