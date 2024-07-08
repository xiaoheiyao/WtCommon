package com.wt.commonres.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.wt.commonres.log.WTLog

open class BaseActivity : AppCompatActivity() {

    var TAG = this.javaClass.getSimpleName()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        WTLog.i("Lifecycle", "$TAG onCreate persistentState")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WTLog.i("Lifecycle", "$TAG onCreate")
    }

    override fun onStart() {
        super.onStart()
        WTLog.i("Lifecycle", "$TAG onStart")
    }

    override fun onResume() {
        super.onResume()
        WTLog.i("Lifecycle", "$TAG onResume")
    }

    override fun onPause() {
        super.onPause()
        WTLog.i("Lifecycle", "$TAG onPause")
    }

    override fun onStop() {
        super.onStop()
        WTLog.i("Lifecycle", "$TAG onStop")
    }

    override fun onRestart() {
        super.onRestart()
        WTLog.i("Lifecycle", "$TAG onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        WTLog.i("Lifecycle", "$TAG onDestroy")
    }


}