package com.marcinmoskala.minions

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

fun <T, I> ArrayAdapter<I>.getAnyView(position: Int, view: View?, parent: ViewGroup?, layoutId: Int, getHolder: (View) -> T, setUp: (I, T) -> Unit): View {
    val (holder, newView) = if (view != null) getViewFromTag<T>(view) else inflateViewSetTagAndGetHolder(getHolder, layoutId, parent)
    setUp(getItem(position), holder)
    return newView
}

private fun <T> getViewFromTag(view: View) = @Suppress("UNCHECKED_CAST") (view.tag as T) to view

private fun <I, T> ArrayAdapter<I>.inflateViewSetTagAndGetHolder(getHolder: (View) -> T, layoutId: Int, parent: ViewGroup?): Pair<T, View> {
    val newView = context.inflater.inflate(layoutId, parent, false)
    val holder = getHolder(newView)
    newView.tag = holder
    return holder to newView
}