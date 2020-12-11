package com.vitroop.dindin.data.repository

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.virtroop.dindin.data.model.Summary
import com.virtroop.dindin.data.remote.SummaryService
import com.virtroop.dindin.data.repository.SummaryRepository
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Test
import retrofit2.Response

class SummaryRepositoryTest {

  private val mockSummary = mock<Summary> {
    on { bookName } doReturn BOOK_NAME
  }
  private val mockSummaryService = mock<SummaryService> {
    on { getSummaries() } doReturn Single.just<Response<Summary>>(Response.success(mockSummary))
  }

  private val summaryRepository = SummaryRepository(mockSummaryService)

  @Test
  fun testSingleGetSummariesWithSuccess() {
    val observer = TestObserver<Summary>()

    summaryRepository.singleGetSummaries().subscribe(observer)

    verify(mockSummaryService).getSummaries()
    observer.assertValue { it.bookName == BOOK_NAME }
    observer.assertComplete()
  }

  private companion object {
    private const val BOOK_NAME = "lebook"
  }
}
