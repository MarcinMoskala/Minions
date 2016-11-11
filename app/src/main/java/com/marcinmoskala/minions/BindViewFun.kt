@file:Suppress("UNCHECKED_CAST")

package com.marcinmoskala.minions

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.v7.widget.RecyclerView.ViewHolder

fun  <T> Activity.bindView(viewId: Int) = lazy { findViewById(viewId) as T }
fun  <T> Fragment.bindView(viewId: Int) = lazy { view.findViewById(viewId) as T }
fun  <T> ViewHolder.bindView(viewId: Int) = lazy { itemView.findViewById(viewId) as T }
fun  <T> Dialog.bindView(viewId: Int) = lazy { findViewById(viewId) as T }
