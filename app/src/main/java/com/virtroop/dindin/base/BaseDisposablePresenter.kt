package com.virtroop.dindin.base

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.virtroop.dindin.rx.SchedulerComposer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseDisposablePresenter<V : MvpView>(
  open val schedulerComposer: SchedulerComposer
) : MvpBasePresenter<V>(), MvpPresenter<V> {
  var compositeDisposable: CompositeDisposable? = null

  override fun attachView(view: V) {
    compositeDisposable = CompositeDisposable()
    super.attachView(view)
  }

  override fun detachView() {
    compositeDisposable?.dispose()
    compositeDisposable = null
    super.detachView()
  }

  internal fun addDisposable(disposable: Disposable) {
    compositeDisposable?.add(disposable)
  }

  internal fun addDisposable(actionToDispose: () -> Disposable) {
    compositeDisposable?.add(actionToDispose())
  }

  internal fun removeDisposable(disposable: Disposable) {
    compositeDisposable?.remove(disposable)
  }

}
