package com.virtroop.dindin.rx

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler

internal class ObservableComposer(
    private val subscribeScheduler: Scheduler,
    private val observeScheduler: Scheduler = subscribeScheduler
) : ObservableTransformer<Any, Any> {
  override fun apply(upstream: Observable<Any>) = upstream.subscribeOn(subscribeScheduler).observeOn(observeScheduler)
}
