package com.marcinmoskala.minions

import android.R
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

abstract class CustomListAdapter<T, I>(context: Context, list: List<I>, val viewLayoutId: Int) : ArrayAdapter<I>(context, R.layout.simple_list_item_1, list) {

    protected val inflater = context.inflater

    abstract fun getViewHolder(view: View): T

    abstract fun T.setUpView(item: I)

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        return getAnyView(position, view, parent, viewLayoutId, { v -> getViewHolder(v) }, { b, holder -> holder.setUpView(b) })
    }
}
