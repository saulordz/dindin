package com.vitroop.dindin.shadow;

import android.webkit.ValueCallback;
import android.webkit.WebView;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

/**
 * Robolectric Shadow for mocking WebViews's call to <code>super.evaluateJavascript()</code>, which
 * fails otherwise.
 */
@Implements(WebView.class)
public class ShadowWebView extends org.robolectric.shadows.ShadowWebView {
  @Implementation(minSdk = 19)
  public void evaluateJavascript(String script, ValueCallback<String> callback) {
    super.evaluateJavascript(script, callback);
    callback.onReceiveValue(null);
  }

}
