package com.virtroop.dindin.data.model

import com.squareup.moshi.Json

data class Summary(
  @field:Json(name = "bookAudio") val bookAudio: String? = null,
  @field:Json(name = "bookCover") val bookCover: String? = null,
  @field:Json(name = "bookName") val bookName: String? = null,
  @field:Json(name = "bookText") val bookText: String? = null
)
