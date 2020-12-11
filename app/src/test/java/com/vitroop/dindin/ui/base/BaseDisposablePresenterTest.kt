package com.vitroop.dindin.ui.base

import assertk.assert
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
import assertk.assertions.isNull
import assertk.assertions.isTrue
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.nhaarman.mockito_kotlin.mock
import com.virtroop.dindin.base.BaseDisposablePresenter
import com.virtroop.dindin.rx.SchedulerComposer
import com.vitroop.common.TestUtils.schedulerComposer
import io.reactivex.Completable
import org.junit.After
import org.junit.Before
import org.junit.Test

class BaseDisposablePresenterTest {

  private val mockView = mock<MvpView>()

  private lateinit var presenter: ConcreteDisposablePresenter

  @Before
  fun setUp() {
    presenter =
      ConcreteDisposablePresenter(
        schedulerComposer
      )
    presenter.attachView(mockView)
  }

  @After
  fun tearDown() {
  }

  @Test
  fun testAttachView() {
    presenter.detachView()

    presenter.attachView(mockView)

    assert(presenter.compositeDisposable).isNotNull()
  }

  @Test
  fun testDetachView() {
    val disposable = Completable.complete().subscribe()
    presenter.compositeDisposable?.add(disposable)

    presenter.detachView()

    assert(disposable.isDisposed).isTrue()
    assert(presenter.compositeDisposable).isNull()
  }

  @Test
  fun testAddDisposable() {
    val disposable = Completable.complete().subscribe()

    presenter.addDisposable(disposable)

    assert(presenter.compositeDisposable?.remove(disposable)).isEqualTo(true)
  }

  @Test
  fun testAddDisposableWithAction() {
    val disposable = Completable.complete().subscribe()
    val actionToDispose = { disposable }

    presenter.addDisposable(actionToDispose)

    assert(presenter.compositeDisposable?.remove(disposable)).isEqualTo(true)
  }

  @Test
  fun testRemoveDisposable() {
    val disposable = Completable.complete().subscribe()

    presenter.removeDisposable(disposable)

    assert(presenter.compositeDisposable?.size()).isEqualTo(0)
  }

  private class ConcreteDisposablePresenter(
    schedulerComposer: SchedulerComposer
  ) : BaseDisposablePresenter<MvpView>(schedulerComposer)
}
