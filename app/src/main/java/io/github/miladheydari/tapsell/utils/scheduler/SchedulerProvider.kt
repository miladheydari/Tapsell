package io.github.miladheydari.tapsell.utils.scheduler


import io.reactivex.Scheduler

interface SchedulerProvider {

    fun mainThread(): Scheduler

    fun backgroundThread(): Scheduler

    fun computationThread(): Scheduler
}
