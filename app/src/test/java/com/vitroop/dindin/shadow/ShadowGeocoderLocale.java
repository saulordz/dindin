package com.vitroop.dindin.shadow;

import android.content.Context;
import android.location.Geocoder;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.Resetter;
import org.robolectric.shadow.api.Shadow;

import java.util.Locale;

@Implements(Geocoder.class)
public class ShadowGeocoderLocale {

  private static boolean isPresent = true;
  private Locale locale;

  public void __constructor__(Context context, Locale locale) {
    this.locale = locale;
  }

  public Locale getLocale() {
    return locale;
  }

  @Implementation
  public static boolean isPresent() {
    return isPresent;
  }

  public static void setIsPresent(boolean value) {
    isPresent = value;
  }

  @Resetter
  public static void reset() {
    isPresent = true;
  }

  public static ShadowGeocoderLocale shadowOf(Geocoder actual) {
    return (ShadowGeocoderLocale) Shadow.extract(actual);
  }
}
