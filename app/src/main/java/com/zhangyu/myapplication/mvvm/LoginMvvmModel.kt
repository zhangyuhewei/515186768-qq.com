package com.zhangyu.myapplication.mvvm

import com.zhangyu.myapplication.network.RetrofitManager

/**
 *author：created by zhangyu
 *date：2020/4/1 0001 14
 *description
 */
class LoginMvvmModel() {

    suspend fun login(name: String, pwd: String) =
        RetrofitManager.apiService.login(name, pwd)
}