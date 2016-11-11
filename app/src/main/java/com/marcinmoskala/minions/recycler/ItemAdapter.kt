package com.marcinmoskala.minions.recycler

import android.support.annotation.LayoutRes
import android.view.View

abstract class ItemAdapter<T : BaseViewHolder>(@LayoutRes open val layoutId: Int) {

    var holder: T? = null

    abstract fun onCreateViewHolder(itemView: View): T

    @Suppress("UNCHECKED_CAST")
    fun onBindBaseViewHolder(holder: BaseViewHolder) {
        this.holder = holder as T
        holder.onBindViewHolder()
    }

    abstract fun T.onBindViewHolder()
}
