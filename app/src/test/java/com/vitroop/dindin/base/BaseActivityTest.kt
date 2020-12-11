package com.vitroop.dindin.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.robolectric.Robolectric
import org.robolectric.android.controller.ActivityController
import toothpick.Toothpick
import toothpick.testing.ToothPickRule
import java.lang.IllegalStateException

abstract class BaseActivityTest : BaseRobolectricTest() {

  enum class Phase {
    Created, Started, Resumed, Visible, Paused, Stopped, Destroyed
  }

  @Rule
  @JvmField val activityScopeToothpickRule: ToothPickRule = ToothPickRule(this)

  @Before
  fun setUp() {
    activityScopeToothpickRule.inject(this)
  }

  @After
  fun cleanUp() {
    Toothpick.reset()
  }

  inline fun <reified A : AppCompatActivity> withActivity(intent: Intent? = null, noinline action: ((A) -> Unit)? = null) = withActivityController(createActivityController(intent), action)

  inline fun <reified A : AppCompatActivity> withActivityAndController(intent: Intent? = null, noinline action: ((A, ActivityController<A>) -> Unit)? = null) = withActivityController(createActivityController(intent), action)

  inline fun <reified A : AppCompatActivity> withVisibleActivity(noinline action: ((A) -> Unit)? = null) = withActivityController(createActivityController(), action, Phase.Visible)

  inline fun <reified A : AppCompatActivity> withResumedActivity(intent: Intent? = null, noinline action: ((A) -> Unit)? = null) = withActivityController(createActivityController(intent), action, Phase.Resumed)

  inline fun <reified A : AppCompatActivity> withStartedActivity(noinline action: ((A) -> Unit)? = null) = withActivityController(createActivityController(), action, Phase.Started)

  inline fun <reified A : AppCompatActivity> withPausedActivity(noinline action: ((A) -> Unit)? = null) = withActivityController(createActivityController(), action, Phase.Paused)

  inline fun <reified A : AppCompatActivity> withStoppedActivity(noinline action: ((A) -> Unit)? = null) = withActivityController(createActivityController(), action, Phase.Stopped)

  fun <A : AppCompatActivity> withActivityController(controller: ActivityController<A>, action: ((A) -> Unit)? = null, phase: Phase = Phase.Created) {
    val activity = controller.get()
    activityScopeToothpickRule.setScopeName(activity)
    try {
      when (phase) {
        Phase.Visible -> controller.create().start().resume().visible()
        Phase.Resumed -> controller.create().start().resume()
        Phase.Started -> controller.create().start()
        Phase.Paused -> controller.create().start().resume().visible().pause()
        Phase.Stopped -> controller.create().start().resume().visible().pause().stop()
        Phase.Destroyed -> controller.create().start().resume().visible().pause().stop().destroy()
        else -> controller.create()
      }
      action?.invoke(activity)
    } finally {
      activity?.finish()
      try {
        controller.destroy()
      } catch (e: IllegalStateException) {
        if (e.message != "Fragment host has been destroyed") {
          throw e
        }
      }
    }
  }

  fun <A : AppCompatActivity> withActivityController(controller: ActivityController<A>, action: ((A, ActivityController<A>) -> Unit)? = null) {
    val activity = controller.get()
    activityScopeToothpickRule.setScopeName(activity)
    try {
      action?.invoke(activity, controller)
    } finally {
      activity?.finish()
      try {
        controller.destroy()
      } catch (e: IllegalStateException) {
        if (e.message != "Fragment host has been destroyed") {
          throw e
        }
      }
    }
  }

  inline fun <reified B : AppCompatActivity> createActivityController(intent: Intent? = null): ActivityController<B> =
    Robolectric.buildActivity(B::class.java, intent)
}
