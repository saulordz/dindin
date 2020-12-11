package com.virtroop.dindin

import android.app.Application
import com.github.stephanenicolas.toothpick.smoothie.BuildConfig
import com.virtroop.dindin.di.DataModule
import com.virtroop.dindin.di.RxModule
import com.virtroop.dindin.di.Scopes
import toothpick.Scope
import toothpick.Toothpick
import toothpick.configuration.Configuration
import toothpick.smoothie.module.SmoothieApplicationModule

open class DinDinApplication : Application() {

  internal open val modules
    get() = arrayOf(SmoothieApplicationModule(this), RxModule(), DataModule())

  lateinit var scope: Scope

  override fun onCreate() {
    super.onCreate()

    initializeToothpick()
  }

  internal open fun initializeToothpick() {
    val configuration = if (BuildConfig.DEBUG) {
      Configuration.forDevelopment()
    } else {
      Configuration.forProduction()
    }
    Toothpick.setConfiguration(configuration)

    scope = Toothpick.openScope(Scopes.AppScope::class.java)
    scope.installModules(*modules)
    Toothpick.inject(this, scope)
  }
}
