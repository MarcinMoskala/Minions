package com.marcinmoskala.minions

import android.view.View

fun View.show() { visibility = View.VISIBLE }

fun View.hide() { visibility = View.GONE }

fun View.enable() { isEnabled = true }

fun View.disable() { isEnabled = false }
