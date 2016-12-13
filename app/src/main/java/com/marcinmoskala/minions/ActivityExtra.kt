@file:Suppress("UNCHECKED_CAST")

package com.marcinmoskala.minions

import android.app.Activity
import android.support.v4.app.Fragment
import android.os.Parcelable
import org.joda.time.DateTime
import org.joda.time.LocalDate
import java.io.Serializable
import kotlin.LazyThreadSafetyMode.NONE

fun <T : Parcelable> Activity.extra(key: String, default: T? = null): Lazy<T> = lazy(NONE) { intent?.extras?.getParcelable<T>(key) ?: default ?: throw Error("No value $key") }
fun <T : Serializable?> Activity.serializableExtra(key: String, default: T): Lazy<T> = lazy(NONE) { (intent?.extras?.getSerializable(key) as? T) ?: default }
fun Activity.extraBoolean(key: String, default: Boolean): Lazy<Boolean> = lazy(NONE) { intent?.extras?.getBoolean(key, default) ?: default }
fun Activity.extraInt(key: String, default: Int = -1): Lazy<Int> = lazy(NONE) { intent?.extras?.getInt(key) ?: default }
fun Activity.extraDateTime(key: String, default: DateTime? = null): Lazy<DateTime> = lazy(NONE) { intent?.extras?.getString(key)?.parseDateTime() ?: default ?: throw Error("No value $key") }
fun Activity.stringExtra(key: String, default: String? = null): Lazy<String> = lazy(NONE) { intent?.extras?.getString(key) ?: default ?: throw Error("No value $key") }

fun <T : Parcelable> Fragment.extra(key: String, default: T? = null): Lazy<T> = lazy(NONE) { arguments?.getParcelable<T>(key) ?: default ?: throw Error("No value $key") }
fun Fragment.extraLocalDate(key: String, default: LocalDate? = null): Lazy<LocalDate> = lazy(NONE) { arguments?.getCharSequence(key).toString().parseLocalDate() ?: default ?: throw Error("No value $key") }
