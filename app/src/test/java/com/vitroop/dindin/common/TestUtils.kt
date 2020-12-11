package com.vitroop.dindin.common

import com.virtroop.dindin.rx.SchedulerComposer
import com.virtroop.dindin.rx.SchedulerProvider
import io.reactivex.schedulers.Schedulers

object TestUtils {

  internal val schedulerComposer = SchedulerComposer(object : SchedulerProvider {
    override val computation = Schedulers.trampoline()
    override val io = Schedulers.trampoline()
    override val ui = Schedulers.trampoline()
  })

}
