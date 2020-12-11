package com.virtroop.dindin.di

import android.content.res.Resources
import toothpick.config.Module
import toothpick.smoothie.provider.ResourcesProvider

class ActivityModule : Module() {
  init {
    bind(Resources::class.java).toProvider(ResourcesProvider::class.java)
  }
}
