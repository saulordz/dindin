package com.virtroop.dindin.data.remote

import com.virtroop.dindin.data.model.Summary
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface SummaryService {

  @GET("getSummaries")
  fun getSummaries(): Single<Response<Summary>>

}

