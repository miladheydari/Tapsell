package io.github.miladheydari.tapsell.repository.api

import io.github.miladheydari.tapsell.repository.api.model.NoteModel
import io.github.miladheydari.tapsell.repository.api.model.Response
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitInterface  {
    @POST("anything")
    fun sendData(@Body body: NoteModel): Single<Response>

}