package com.virtroop.dindin.di

import com.virtroop.dindin.rx.ApplicationSchedulerProvider
import com.virtroop.dindin.rx.SchedulerProvider
import toothpick.config.Module

class RxModule : Module() {
  init {
    bind(SchedulerProvider::class.java).to(ApplicationSchedulerProvider::class.java)
  }
}
