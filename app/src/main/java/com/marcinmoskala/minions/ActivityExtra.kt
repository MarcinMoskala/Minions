@file:Suppress("UNCHECKED_CAST")

package com.marcinmoskala.minions

import android.app.Activity
import android.support.v4.app.Fragment
import android.os.Parcelable
import org.joda.time.DateTime
import org.joda.time.LocalDate
import java.io.Serializable
import kotlin.LazyThreadSafetyMode.NONE

fun <T : Parcelable> Activity.extra(key: String, default: T? = null) = lazy(NONE) { intent?.extras?.getParcelable<T>(key) ?: default }
fun <T : Serializable?> Activity.serializableExtra(key: String, default: T): Lazy<T> = lazy(NONE) { (intent?.extras?.getSerializable(key) as? T) ?: default }
fun Activity.extraBoolean(key: String, default: Boolean) = lazy(NONE) { intent?.extras?.getBoolean(key, default) ?: default }
fun Activity.extraInt(key: String, default: Int? = null) = lazy(NONE) { intent?.extras?.getInt(key) ?: default }

fun <T : Parcelable> Fragment.extra(key: String, default: T? = null) = lazy(NONE) { arguments?.getParcelable<T>(key) ?: default }
fun Fragment.extraLocalDate(key: String, default: LocalDate? = null) = lazy(NONE) { arguments?.getCharSequence(key).toString().parseLocalDate() ?: default }
fun Activity.extraDateTime(key: String, default: DateTime? = null) = lazy(NONE) { intent?.extras?.getString(key)?.parseDateTime() ?: default }
fun Activity.stringExtra(key: String, default: String? = null) = lazy(NONE) { intent?.extras?.getString(key) ?: default }