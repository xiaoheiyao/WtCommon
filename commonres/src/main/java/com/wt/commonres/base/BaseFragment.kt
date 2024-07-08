package com.wt.commonres.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.wt.commonres.log.WTLog

abstract class BaseFragment : Fragment() {


    var TAG = this.javaClass.getSimpleName()

    //输入法管理
    var mBaseImm: InputMethodManager? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        WTLog.i("Lifecycle", "$TAG onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WTLog.i("Lifecycle", "$TAG onCreate")
        mBaseImm =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    }

//    protected var isNavigationViewInit = false//记录是否已经初始化过一次视图
//    private var lastView: View? = null//记录上次创建的view

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        if (lastView == null) {
        WTLog.i("Lifecycle", "$TAG onCreateView")
        val lastView = super.onCreateView(inflater, container, savedInstanceState)
//        }
        return lastView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        if (!isNavigationViewInit) {
        super.onViewCreated(view, savedInstanceState)
        WTLog.i("Lifecycle", "$TAG onViewCreated")
        initObserver()
        initView()
        initData()
//            isNavigationViewInit = true
//        }
    }

    /**
     * 初始化viewModel的观察事件
     */
    open fun initObserver() {}

    /**
     * 初始化view布局
     */
    open fun initView() {}

    /**
     * 初始化data
     */
    open fun initData() {}

    /**
     * 隐藏键盘输入
     */
    fun hideKeyboard() {
        if (mBaseImm != null) {
            val window: Window = requireActivity().window
            var vFocus = window.currentFocus
            vFocus = vFocus ?: window.decorView
            mBaseImm!!.hideSoftInputFromWindow(vFocus.windowToken, 0, null)
        }
    }

    /**
     * 显示键盘输入
     */
    fun showKeyboard(view: View) {
        if (mBaseImm != null) {
            view.requestFocus()
            mBaseImm!!.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    fun toast(msg: String?) {
//        Toast.makeText(this.context, msg, Toast.LENGTH_SHORT).show()
        com.wt.commonres.global.toast("$msg")
    }

    fun toast(resId: Int) {
//        Toast.makeText(this.context, resId, Toast.LENGTH_SHORT).show()
        com.wt.commonres.global.toast(resId)
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

    override fun onDestroyView() {
        super.onDestroyView()
        WTLog.i("Lifecycle", "$TAG onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        WTLog.i("Lifecycle", "$TAG onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        WTLog.i("Lifecycle", "$TAG onDetach")
    }
}