package com.virtroop.dindin.di.remote

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Provider

class OkHttpClientProvider @Inject constructor() : Provider<OkHttpClient> {

  override fun get() =
    OkHttpClient.Builder()
      .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
      .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
      .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
      .build()

  private companion object {
    private const val CONNECT_TIMEOUT = 5L
    private const val READ_TIMEOUT = 30L
    private const val WRITE_TIMEOUT = 30L
  }
}
