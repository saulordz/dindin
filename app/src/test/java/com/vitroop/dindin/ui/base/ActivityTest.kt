package com.vitroop.dindin.ui.base

import android.os.Bundle
import com.nhaarman.mockito_kotlin.mock
import com.virtroop.dindin.R
import com.virtroop.dindin.base.BaseActivity
import com.virtroop.dindin.base.BaseContract
import com.vitroop.dindin.base.BaseActivityTest
import toothpick.Scope

class ActivityTest : BaseActivityTest() {
}

private class ConcreteBaseActivity :
  BaseActivity<BaseContract.View, BaseContract.Presenter<BaseContract.View>>() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_catalog)
  }

  override fun addModules(scope: Scope) = scope

  override fun createPresenter() = mock<BaseContract.Presenter<BaseContract.View>>()
}
