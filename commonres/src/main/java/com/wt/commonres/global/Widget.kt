package com.wt.commonres.global

import android.os.Looper
import android.view.View

/**
 * 设置view的显示和隐藏，使用该方法可以不用考虑View是否在主线程中
 */
fun View.setVisible(b: Boolean) {
    if (Thread.currentThread() == Looper.getMainLooper().thread) {
        visibility = if (b) View.VISIBLE else View.GONE
    } else {
        post { visibility = if (b) View.VISIBLE else View.GONE }
    }
}

/**
 * 设置view的显示和占位隐藏
 */
fun View.setVisibleOrInVisible(b: Boolean) {
    if (Thread.currentThread() == Looper.getMainLooper().thread) {
        visibility = if (b) View.VISIBLE else View.INVISIBLE
    } else {
        post { visibility = if (b) View.VISIBLE else View.INVISIBLE }
    }
}