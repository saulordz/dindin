package com.virtroop.dindin.ui.catalog

import toothpick.config.Module

class CatalogModule : Module() {
  init {
    bind(CatalogContract.Presenter::class.java).to(CatalogPresenter::class.java)
  }
}
