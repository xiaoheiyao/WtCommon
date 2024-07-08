package com.wt.commonres.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.*

/**
 * 包装了协程调用的ViewModel
 *
 */
open class LaunchViewModel : ViewModel() {

    //对结果进行Result<T>包装
    fun <T> launch(live: MutableLiveData<Result<T>>, block: suspend () -> T) {
        viewModelScope.launch(Dispatchers.IO) {
            val result: Result<T> = kotlin.runCatching { block() }.onFailure { it.printStackTrace() }
            live.postValue(result)
        }
    }

    //只关注正确结果T，如果需要处理异常，增加callback回调处理
    fun <T> launchObserve(
        mutableLiveData: MutableLiveData<T>,
        isExceptionWarn: Boolean = false,
        callback: ((Result<T>) -> Unit)? = null,
        block: suspend () -> T
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = kotlin.runCatching { block() }.onFailure { it.printStackTrace() }
            if (result.isSuccess) {
                result.getOrNull()?.apply {
                    mutableLiveData.postValue(this)
                }
            } else if (result.isFailure) { //当执行错误时，报错！！！
                if (isExceptionWarn) {
//                    CpToast.warnToastException(result.exceptionOrNull())
                } else {
//                    CpToast.debugWarn(result.exceptionOrNull()?.message)
                }
            }
            if (callback != null) {
                callback(result)
            }
        }
    }

    //协程中运行，主线程回调
    fun <T> launchCallback(block: suspend () -> T, callback: (Result<T>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = kotlin.runCatching { block() }.onFailure { it.printStackTrace() }
            withContext(Dispatchers.Main) { callback(result) }
        }
    }

    //协程中运行，不关注运行结果，逻辑全部由block决定
    fun launch(dispatcher: CoroutineDispatcher = Dispatchers.IO, block: suspend () -> Unit): Job {
        return viewModelScope.launch(dispatcher) {
            kotlin.runCatching { block() }.onFailure { it.printStackTrace() }
        }
    }
}