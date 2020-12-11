package com.vitroop.dindin.common.extensions

import android.widget.TextView
import assertk.Assert
import assertk.assertions.isEqualTo

internal fun Assert<TextView>.hasText(expectedCharSequence: CharSequence) =
  assert(actual.text?.toString()).isEqualTo(expectedCharSequence.toString())
