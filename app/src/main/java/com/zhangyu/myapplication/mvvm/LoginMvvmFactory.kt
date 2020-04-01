package com.zhangyu.myapplication.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 *author：created by zhangyu
 *date：2020/4/1 0001 15
 *description
 */
class LoginMvvmFactory(private var model: LoginMvvmModel): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginMvvmViewModel(model) as T
    }
}