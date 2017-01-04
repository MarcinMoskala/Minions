package com.marcinmoskala.minions

import android.content.Context
import android.os.Handler
import android.os.Looper

inline fun Context.runOnUiThread(crossinline f: ()->Unit) {
    Handler(Looper.getMainLooper()).post { f() }
}