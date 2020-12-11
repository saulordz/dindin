package com.virtroop.dindin.rx

import io.reactivex.Maybe
import io.reactivex.MaybeTransformer
import io.reactivex.Scheduler

internal class MaybeComposer(
    private val subscribeScheduler: Scheduler,
    private val observeScheduler: Scheduler = subscribeScheduler
) : MaybeTransformer<Any, Any> {
  override fun apply(upstream: Maybe<Any>) = upstream.subscribeOn(subscribeScheduler).observeOn(observeScheduler)
}
