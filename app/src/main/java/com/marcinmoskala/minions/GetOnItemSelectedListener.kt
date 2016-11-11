package com.marcinmoskala.minions

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.SpinnerAdapter

fun <T> Spinner.simpleOnItemSelectedListener(onElementChosen: (T, position: Int) -> Unit): AdapterView.OnItemSelectedListener {
    return IgnoreFirstSelectAdapterListener(onElementChosen, adapter)
}

class IgnoreFirstSelectAdapterListener<in T>(val onElementChosen: (T, Int) -> Unit, val adapter: SpinnerAdapter) : AdapterView.OnItemSelectedListener {
    var firstTime = true

    override fun onNothingSelected(adapter: AdapterView<*>?) {
    }

    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if(firstTime) {
            firstTime = false
            return
        }
        @Suppress("UNCHECKED_CAST")
        val item = adapter.getItem(position) as T
        onElementChosen(item, position)
    }
}