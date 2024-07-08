package com.wt.commonres.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

/**
 * 这个基类主要封装的是ViewBinding和ViewModel相关，没有针对Compose
 */
abstract class MvvmFragment<T : ViewBinding> : BaseFragment() {


    //以懒加载的形式，用于实例化ViewModel对象
    val vmProvider: ViewModelProvider by lazy { ViewModelProvider(this) }

    val lifeObservers: LiveObserves by lazy { LiveObserves(this) }

    //inline 关键字：这表示函数是内联函数，它可以在编译时将函数体的代码插入到调用它的地方，以提高性能。
    //reified 主要用于以下情况：内联函数中获取泛型的实际类型
    inline fun <reified T : ViewModel> vm() = lazy { vmProvider[T::class.java] }

    //binding 要及时的创建和销毁
    private var _binding: T? = null

    //对binding进行封装，使其仅在onCreateView和onDestroyView之间有效。
    protected val binding get() = _binding!!

    /*安全的binding，可以为null，一般在协程中使用，防止binding被销毁导致的空指针异常*/
    protected val safeBinding get() = _binding


    /**
     * 获得具体实现类的binding对象
     */
    abstract fun getBinding(inflater: LayoutInflater, container: ViewGroup?): T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = getBinding(inflater, container)

        val root: View = _binding!!.root

        return root
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        lifeObservers.destroy()
        _binding = null
    }
}