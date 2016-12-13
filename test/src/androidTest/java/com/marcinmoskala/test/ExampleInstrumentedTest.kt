package com.marcinmoskala.test

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
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

    @Test fun usePreferencesUsage() {
        val c = InstrumentationRegistry.getTargetContext()
        val someText = "Some text"
        c.preferences.savedSomeText = someText
        val a = c.preferences.savedSomeText
        assertTrue(c.preferences.savedSomeText == someText)
    }
}
