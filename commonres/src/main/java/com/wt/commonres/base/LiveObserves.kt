package com.wt.commonres.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * LiveObserves observe LiveData
 * 内部仍然为 LiveData observe LifecycleOwner
 * @property owner
 */
class LiveObserves(private val owner: LifecycleOwner) {

    private val liveDataSet by lazy { HashSet<LiveData<*>>(3) }


    //自动释放Observer的LiveData
    fun <T> observe(liveData: LiveData<T>, observer: Observer<T>) {
        if (owner.lifecycle.currentState == Lifecycle.State.DESTROYED) return
        liveData.observe(owner, observer)
        liveDataSet.add(liveData)
    }

    fun destroy() {
        liveDataSet.forEach { liveData -> liveData.removeObservers(owner) }
        liveDataSet.clear()
    }
}