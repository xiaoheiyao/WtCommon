package com.wt.commonres.global

import com.wt.commonres.utils.ToastContext
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Calendar

/**
 * 全局基类，用于放置一些全局都能直接使用的方法
 */


val format7 = DecimalFormat("#.#######")
val format2 = DecimalFormat("#.##")
val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
const val DEF_FORMAT = "yyyy-MM-dd HH:mm"
const val YEAR_MONTH_DAY = "yyyy-MM-dd"

/**
 * toast 弹窗
 */
fun toast(msg: String?) {
    ToastContext.getInstance().toastShort(msg)
}

/**
 * toast 弹窗
 */
fun toast(resId: Int) {
    ToastContext.getInstance().toastShort(resId)
}