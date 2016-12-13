package com.marcinmoskala.test

import android.content.Context
import android.content.SharedPreferences
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.marcinmoskala.minions.bindToPreferenceField
import com.marcinmoskala.minions.preferences

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test fun useAppContext() {
        val c = InstrumentationRegistry.getTargetContext()
        assertEquals("com.marcinmoskala.test", c.packageName)
    }

    @Test fun usePreferencesString() {
        val c = InstrumentationRegistry.getTargetContext()
        c.preferences.edit().clear().apply()
        assertNull(c.preferences.savedSomeText)
        val someText = "Some text"
        c.preferences.savedSomeText = someText
        assertEquals(someText, c.preferences.savedSomeText)
    }

    @Test fun usePreferencesInt() {
        val c = InstrumentationRegistry.getTargetContext()
        c.preferences.edit().clear().apply()
        assertEquals(0, c.preferences.savedSomeInt)
        val someNumber = 3424
        c.preferences.savedSomeInt = someNumber
        assertEquals(someNumber, c.preferences.savedSomeInt)
    }

    @Test fun usePreferencesLong() {
        val c = InstrumentationRegistry.getTargetContext()
        c.preferences.edit().clear().apply()
        assertEquals(0, c.preferences.savedSomeInt)
        val someNumber: Long = 3424L
        c.preferences.savedSomeLong = someNumber
        assertEquals(someNumber, c.preferences.savedSomeLong!!)
    }

    @Test fun usePreferencesList() {
        val c = InstrumentationRegistry.getTargetContext()
        c.preferences.edit().clear().apply()
        assertEquals(emptyList<Double>(), c.preferences.savedSomeList!!)
        val someList = listOf(1.2, 32.24, 113.22)
        c.preferences.savedSomeList = someList
        assertEquals(someList, c.preferences.savedSomeList)
    }

    @Test fun usePreferencesObject() {
        val c = InstrumentationRegistry.getTargetContext()
        c.preferences.edit().clear().apply()
        assertNull(c.preferences.savedSomeObject)
        val o1 = SomeClass("KO", 23, listOf(3.3,41.2), null)
        c.preferences.savedSomeObject = o1
        assertEquals(o1, c.preferences.savedSomeObject)
        val o2 = SomeClass("KO", 23, listOf(3.3,41.2), SomeClass("KO", 23, listOf(3.3,41.2), SomeClass("KO", 23, listOf(3.3,41.2), null)))
        c.preferences.savedSomeObject = o2
        assertEquals(o2, c.preferences.savedSomeObject)
    }
}
