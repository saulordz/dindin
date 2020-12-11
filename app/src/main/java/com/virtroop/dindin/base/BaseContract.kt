package com.virtroop.dindin.base

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface BaseContract {
  interface View : MvpView {
  }

  interface Presenter<V : View> : MvpPresenter<V> {

  }
}
