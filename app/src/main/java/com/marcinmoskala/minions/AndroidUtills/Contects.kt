@file:Suppress("PackageDirectoryMismatch")

package com.marcinmoskala.minions

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.ContactsContract.PhoneLookup.*
import android.support.v4.content.ContextCompat


// Function check if number is in contacts list
fun Context.contactExists(number: String): Boolean {
    val lookupUri = Uri.withAppendedPath(CONTENT_FILTER_URI, Uri.encode(number))
    val cursor = contentResolver.query(lookupUri, arrayOf(_ID, NUMBER, DISPLAY_NAME), null, null, null)
    return try {
        cursor!!.moveToFirst()
    } finally {
        cursor?.close()
    }
}

val Context.canReadContacts: Boolean
    get() = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED