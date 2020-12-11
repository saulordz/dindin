package com.virtroop.dindin.rx

import io.reactivex.Completable
import io.reactivex.CompletableTransformer
import io.reactivex.Scheduler

internal class CompletableComposer(
    private val subscribeScheduler: Scheduler,
    private val observeScheduler: Scheduler = subscribeScheduler
) : CompletableTransformer {
  override fun apply(upstream: Completable) = upstream.subscribeOn(subscribeScheduler).observeOn(observeScheduler)
}
