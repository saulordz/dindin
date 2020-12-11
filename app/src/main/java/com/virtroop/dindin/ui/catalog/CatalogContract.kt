package com.virtroop.dindin.ui.catalog

import com.virtroop.dindin.base.BaseContract

interface CatalogContract {
  interface View : BaseContract.View {
    fun sayHello(result: String)
  }

  interface Presenter : BaseContract.Presenter<View> {
    fun calculateHello()
  }
}
