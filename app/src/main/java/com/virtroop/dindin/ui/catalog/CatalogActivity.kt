package com.virtroop.dindin.ui.catalog

import android.os.Bundle
import com.virtroop.dindin.R
import com.virtroop.dindin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_catalog.*
import toothpick.Scope
import javax.inject.Inject

class CatalogActivity : BaseActivity<CatalogContract.View, CatalogContract.Presenter>(),
  CatalogContract.View {

  @Inject
  lateinit var catalogPresenter: CatalogContract.Presenter

  override fun addModules(scope: Scope): Scope = scope.installModules(CatalogModule())

  override fun createPresenter(): CatalogContract.Presenter = catalogPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_catalog)

    presenter.calculateHello()
  }

  override fun sayHello(result: String) {
    a_catalog_hello.text = result
  }
}
