package com.marcinmoskala.test

import android.content.SharedPreferences
import com.marcinmoskala.minions.bindToPreferenceField


var SharedPreferences.savedSomeText: String? by bindToPreferenceField(null)
var SharedPreferences.savedSomeLong: Long? by bindToPreferenceField(0L)
var SharedPreferences.savedSomeInt: Int? by bindToPreferenceField(0)
var SharedPreferences.savedSomeList: List<Double>? by bindToPreferenceField(listOf())
var SharedPreferences.savedSomeObject: SomeClass? by bindToPreferenceField(null)

data class SomeClass(val str: String, var int: Int, val list: List<Double>, var itself: SomeClass?)
