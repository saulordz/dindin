package com.virtroop.dindin.di

import com.virtroop.dindin.data.remote.SummaryService
import com.virtroop.dindin.di.remote.*
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import toothpick.config.Module

class DataModule : Module() {
  init {
    bind(OkHttpClient::class.java).toProvider(OkHttpClientProvider::class.java)
    bind(Converter.Factory::class.java).toProvider(MoshiConverterFactoryProvider::class.java)
    bind(CallAdapter.Factory::class.java).toProvider(RxJavaAdapterFactoryProvider::class.java)
    bind(Retrofit::class.java).toProvider(RetrofitProvider::class.java)
    bind(SummaryService::class.java).toProvider(SummaryServiceProvider::class.java)
  }
}
