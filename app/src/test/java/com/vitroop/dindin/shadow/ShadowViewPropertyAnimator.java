package com.vitroop.dindin.shadow;

import android.view.ViewPropertyAnimator;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;

/**
 * Robolectric Shadow for mocking ViewPropertyAnimators's calls because of bug https://github.com/robolectric/robolectric/issues/2930
 */
@Implements(ViewPropertyAnimator.class)
public class ShadowViewPropertyAnimator {
  @RealObject
  private ViewPropertyAnimator realViewPropertyAnimator;

  private float rotationX;

  @SuppressWarnings("unused")
  @Implementation
  public ViewPropertyAnimator rotationX(float value) {
    rotationX = value;
    return realViewPropertyAnimator;
  }

  public float getRotationX() {
    return rotationX;
  }
}
