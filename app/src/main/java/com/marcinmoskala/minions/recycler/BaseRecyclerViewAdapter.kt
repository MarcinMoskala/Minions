package com.marcinmoskala.minions.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

open class BaseRecyclerViewAdapter<in T : ItemAdapter<out BaseViewHolder>>(private val items: MutableList<T>) :
        RecyclerView.Adapter<BaseViewHolder>() {

    override final fun getItemCount() = items.size

    override final fun getItemViewType(position: Int) = items[position].layoutId

    override final fun onCreateViewHolder(parent: ViewGroup, layoutId: Int): BaseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return items.first { it.layoutId == layoutId }.onCreateViewHolder(itemView)
    }

    override final fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        items[position].onBindBaseViewHolder(holder)
    }

    fun add(itemAdapter: T) {
        items.add(itemAdapter)
        val index = items.indexOf(itemAdapter)
        if (index == -1) return
        notifyItemInserted(index)
    }

    fun delete(itemAdapter: T) {
        val index = items.indexOf(itemAdapter)
        if (index == -1) return
        items.removeAt(index)
        notifyItemRemoved(index)
    }

    fun replace(from: T, to: T) {
        val index = items.indexOf(from)
        if (index == -1) return
        items.removeAt(index)
        items.add(index, to)
        notifyItemChanged(index)
    }
}
