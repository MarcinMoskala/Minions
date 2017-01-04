package com.marcinmoskala.minions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

inline fun <reified T : Activity> Activity.switchToActivity(vararg params: Pair<String, Any>) {
    startActivity<T>(*params)
    finish()
}

fun Activity.switchToActivity(intent: Intent) {
    startActivity(intent)
    finish()
}

inline fun <reified T: Activity> Context.startActivity(vararg params: Pair<String, Any?>) {
    startActivity(intentFor<T>(*params))
}

inline fun <reified T: Activity> Context.intentFor(vararg params: Pair<String, Any?>): Intent {
    val intent = Intent(this, T::class.java)
    if (params.isNotEmpty()) fillIntentArguments(intent, params.filter { it.second != null }.map { it.first to it.second!! })
    return intent
}

fun fillIntentArguments(intent: Intent, params: List<Pair<String, Any>>) {
    params.forEach {
        val value = it.second
        when (value) {
            is Int -> intent.putExtra(it.first, value)
            is Long -> intent.putExtra(it.first, value)
            is CharSequence -> intent.putExtra(it.first, value)
            is String -> intent.putExtra(it.first, value)
            is Float -> intent.putExtra(it.first, value)
            is Double -> intent.putExtra(it.first, value)
            is Char -> intent.putExtra(it.first, value)
            is Short -> intent.putExtra(it.first, value)
            is Boolean -> intent.putExtra(it.first, value)
            is Serializable -> intent.putExtra(it.first, value)
            is Bundle -> intent.putExtra(it.first, value)
            is Parcelable -> intent.putExtra(it.first, value)
            is Array<*> -> when {
                value.isArrayOf<CharSequence>() -> intent.putExtra(it.first, value)
                value.isArrayOf<String>() -> intent.putExtra(it.first, value)
                value.isArrayOf<Parcelable>() -> intent.putExtra(it.first, value)
                else -> throw Exception("Intent extra ${it.first} has wrong type ${value.javaClass.name}")
            }
            is IntArray -> intent.putExtra(it.first, value)
            is LongArray -> intent.putExtra(it.first, value)
            is FloatArray -> intent.putExtra(it.first, value)
            is DoubleArray -> intent.putExtra(it.first, value)
            is CharArray -> intent.putExtra(it.first, value)
            is ShortArray -> intent.putExtra(it.first, value)
            is BooleanArray -> intent.putExtra(it.first, value)
            else -> throw Exception("Intent extra ${it.first} has wrong type ${value.javaClass.name}")
        }
    }
}