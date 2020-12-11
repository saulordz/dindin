package com.virtroop.dindin.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ApplicationSchedulerProvider @Inject constructor() : SchedulerProvider {

  override val io: Scheduler = Schedulers.io()
  override val computation: Scheduler = Schedulers.computation()
  override val ui: Scheduler = AndroidSchedulers.mainThread()
}
