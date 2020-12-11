package com.virtroop.dindin.rx

import io.reactivex.CompletableTransformer
import io.reactivex.MaybeTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer
import javax.inject.Inject

class SchedulerComposer @Inject constructor(schedulerProvider: SchedulerProvider) {

  private val singleIoUiComposer = SingleComposer(schedulerProvider.io, schedulerProvider.ui)

  private val singleIoIoComposer = SingleComposer(schedulerProvider.io)

  private val observableIoUiComposer = ObservableComposer(schedulerProvider.io, schedulerProvider.ui)

  private val observableIoIoComposer = ObservableComposer(schedulerProvider.io)

  private val completableIoUiComposer = CompletableComposer(schedulerProvider.io, schedulerProvider.ui)

  private val completableComputationUiComposer = CompletableComposer(schedulerProvider.computation, schedulerProvider.ui)

  private val observableUiUiComposer = ObservableComposer(schedulerProvider.ui)

  private val maybeIoUiComposer = MaybeComposer(schedulerProvider.io, schedulerProvider.ui)

  @Suppress("UNCHECKED_CAST")
  fun <I> singleIoIoComposer() = singleIoIoComposer as SingleTransformer<I, I>

  @Suppress("UNCHECKED_CAST")
  fun <I> singleIoUiComposer() = singleIoUiComposer as SingleTransformer<I, I>

  @Suppress("UNCHECKED_CAST")
  fun <I> observableIoUiComposer() = observableIoUiComposer as ObservableTransformer<I, I>

  @Suppress("UNCHECKED_CAST")
  fun <I> observableIoIoComposer() = observableIoIoComposer as ObservableTransformer<I, I>

  @Suppress("UNCHECKED_CAST")
  fun <I> observableUiUiComposer() = observableUiUiComposer as ObservableTransformer<I, I>

  fun completableIoUiComposer(): CompletableTransformer = completableIoUiComposer

  @Suppress("UNCHECKED_CAST")
  fun <I> maybeIoUiComposer() = maybeIoUiComposer as MaybeTransformer<I, I>
}
