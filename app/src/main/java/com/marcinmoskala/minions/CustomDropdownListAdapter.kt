package com.marcinmoskala.minions

import android.content.Context
import android.view.View
import android.view.ViewGroup

abstract class CustomDropdownListAdapter<T, I>(context: Context, list: List<I>, viewLayoutId: Int, val dropdownLayoutId: Int = viewLayoutId) : CustomListAdapter<T, I>(context, list, viewLayoutId) {

    abstract fun getDropdownViewHolder(view: View): T

    abstract fun T.setUpDropdownView(item: I)

    override fun getDropDownView(position: Int, view: View?, parent: ViewGroup?): View {
        return getAnyView(position, view, parent, dropdownLayoutId, { v -> getDropdownViewHolder(v) }, { b, holder -> holder.setUpDropdownView(b) })
    }
}