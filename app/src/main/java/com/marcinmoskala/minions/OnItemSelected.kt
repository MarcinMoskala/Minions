package com.marcinmoskala.minions

import android.view.View
import android.widget.AdapterView

class OnItemSelected(val selected: (Int) -> Unit) : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selected(position)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
}