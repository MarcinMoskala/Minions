package com.marcinmoskala.minions

import android.content.Context

fun Context.dip(value: Int): Int = (value * resources.displayMetrics.density).toInt()
