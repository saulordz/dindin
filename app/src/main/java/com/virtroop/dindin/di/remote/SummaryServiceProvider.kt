package com.virtroop.dindin.di.remote

import com.virtroop.dindin.data.remote.SummaryService
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Provider

class SummaryServiceProvider @Inject constructor(
  private val retrofit: Retrofit
) : Provider<SummaryService> {

  override fun get() = retrofit.create(SummaryService::class.java)

}
