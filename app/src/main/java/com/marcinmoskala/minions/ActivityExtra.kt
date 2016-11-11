@file:Suppress("UNCHECKED_CAST")

package com.marcinmoskala.minions

import android.app.Activity
import android.support.v4.app.Fragment
import android.os.Parcelable
import java.io.Serializable
import kotlin.LazyThreadSafetyMode.NONE

fun <T : Parcelable> Activity.extra(key: String) = lazy(NONE) { intent.extras.getParcelable<T>(key) }
fun <T : Serializable?> Activity.serializableExtra(key: String, default: T): Lazy<T> = lazy(NONE) { (intent.extras.getSerializable(key) as? T) ?: default }
fun Activity.extraBoolean(key: String, default: Boolean) = lazy(NONE) { intent.extras.getBoolean(key, default) }
fun Activity.extraInt(key: String) = lazy(NONE) { intent.extras.getInt(key) }

fun <T : Parcelable> Fragment.extra(key: String) = lazy(NONE) { arguments.getParcelable<T>(key) }
fun Fragment.extraLocalDate(key: String) = lazy(NONE) { arguments.getCharSequence(key).toString().parseLocalDate() }
fun Activity.extraDateTime(key: String) = lazy(NONE) { intent.extras.getString(key).parseDateTime() }
fun Activity.stringExtra(key: String) = lazy(NONE) { intent.extras.getString(key) }