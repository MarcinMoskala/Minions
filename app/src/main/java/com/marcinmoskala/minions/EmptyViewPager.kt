package com.marcinmoskala.minions

import android.support.v4.view.ViewPager

class EmptyViewPager(
        val onPageScrollStateChangedFun: ((state: Int)->Unit)? = null,
        val onPageScrolledFun: ((position: Int, positionOffset: Float, positionOffsetPixels: Int)->Unit)? = null,
        val onPageSelectedFun: ((position: Int)->Unit)? = null
) : ViewPager.OnPageChangeListener {

    override fun onPageScrollStateChanged(state: Int) {
        onPageScrollStateChangedFun?.invoke(state)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        onPageScrolledFun?.invoke(position, positionOffset, positionOffsetPixels)
    }

    override fun onPageSelected(position: Int) {
        onPageSelectedFun?.invoke(position)
    }
}