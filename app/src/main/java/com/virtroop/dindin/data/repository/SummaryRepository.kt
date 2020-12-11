package com.virtroop.dindin.data.repository

import com.virtroop.dindin.data.model.Summary
import com.virtroop.dindin.data.remote.SummaryService
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SummaryRepository @Inject constructor(
  private val summaryService: SummaryService
) {

  fun singleGetSummaries(): Single<Summary> {
    return summaryService.getSummaries()
      .map { it.body() }
  }
}
