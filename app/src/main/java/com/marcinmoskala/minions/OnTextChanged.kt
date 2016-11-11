package com.marcinmoskala.minions

import android.text.Editable
import android.text.TextWatcher

class OnTextChanged(
    val beforeTextChanged: (String) -> Unit = {},
    val onTextChanged: (String) -> Unit = {},
    val afterTextChanged: (String) -> Unit = {}
) : TextWatcher {
    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        beforeTextChanged(s.toString())
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        onTextChanged(s.toString())
    }

    override fun afterTextChanged(s: Editable) {
        afterTextChanged(s.toString())
    }
}
