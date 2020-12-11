package com.virtroop.dindin.ui.catalog

import com.virtroop.dindin.base.BaseDisposablePresenter
import com.virtroop.dindin.data.repository.SummaryRepository
import com.virtroop.dindin.rx.SchedulerComposer
import javax.inject.Inject

class CatalogPresenter @Inject constructor(
  schedulerComposer: SchedulerComposer,
  private val summaryRepository: SummaryRepository
) : BaseDisposablePresenter<CatalogContract.View>(schedulerComposer), CatalogContract.Presenter {

  override fun calculateHello() = addDisposable {
    summaryRepository.singleGetSummaries()
      .compose(schedulerComposer.singleIoUiComposer())
      .subscribe({ helloCalculated(it.bookName.orEmpty()) }) { throw IllegalStateException("Error later") }
  }

  private fun helloCalculated(result: String) = ifViewAttached {
    it.sayHello(result)
  }

}
