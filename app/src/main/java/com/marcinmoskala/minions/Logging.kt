package com.marcinmoskala.minions

import android.util.Log

fun Any.logError(error: Throwable, message: String = "error") {
    Log.e(javaClass.simpleName, message, error)
}
