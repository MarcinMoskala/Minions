package com.marcinmoskala.minions

import android.view.View
import android.widget.TextView

val TextView.trimmedText: String
    get() = text.toString().trim()

var TextView.textOrHide: String?
    get() = if (visibility == View.GONE) "" else text.toString()
    set(value) {
        isVisible = !value.isNullOrBlank()
        text = value
    }

fun TextView.setTextOrHide(id: Int?) {
    if(id == null) hide() else setText(id)
}