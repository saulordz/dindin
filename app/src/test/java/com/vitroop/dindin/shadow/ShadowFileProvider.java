package com.vitroop.dindin.shadow;

import android.content.Context;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import java.io.File;

/**
 * Robolectric Shadow for mocking FileProvider's call to <code>super.getUriForFile()</code>, which
 * fails otherwise. Inspired by
 * <a href="https://github.com/robolectric/robolectric/issues/2199#issuecomment-208976402">idea of
 * JavierSP1209</a>
 */
@Implements(FileProvider.class)
public class ShadowFileProvider {
  @SuppressWarnings("unused")
  @Implementation
  public static Uri getUriForFile(@NonNull Context context, @NonNull String authority, @NonNull File file) {
    return Uri.fromFile(file);
  }
}
