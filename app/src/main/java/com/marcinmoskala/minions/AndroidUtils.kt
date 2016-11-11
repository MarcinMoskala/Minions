package com.marcinmoskala.minions

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.drawable.AnimationDrawable
import android.net.Uri
import android.provider.ContactsContract.PhoneLookup.*
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import android.widget.Toast

private fun <K, V, R> Map<K, V>.foldRight(initial: R, operation: (K, V, R) -> R)
    = toList().foldRight(initial, { m, r -> operation(m.first, m.second, r) })

fun Context.toast(text: String, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, text, length).show()
}

var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

fun ImageView.playAnimation() {
    val animationDrawable = background as AnimationDrawable
    animationDrawable.isOneShot = false
    animationDrawable.start()
}

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