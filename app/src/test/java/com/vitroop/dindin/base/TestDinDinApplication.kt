package com.vitroop.dindin.base

import com.virtroop.dindin.DinDinApplication
import org.robolectric.shadows.ShadowLog
import toothpick.config.Module
import toothpick.smoothie.module.SmoothieApplicationModule

class TestBlankApplication : DinDinApplication() {

  init {
    ShadowLog.setupLogging()
  }

  override val modules: Array<Module>
    get() = arrayOf(SmoothieApplicationModule(this))
}
