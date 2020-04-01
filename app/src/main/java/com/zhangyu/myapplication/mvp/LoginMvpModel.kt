package com.zhangyu.myapplication.mvp

import com.zhangyu.myapplication.network.RetrofitManager

/**
 *author：created by zhangyu
 *date：2020/4/1 0001 11
 *description
 */
class LoginMvpModel() {

    suspend fun login(name:String, pwd:String) =
        RetrofitManager.apiService.login(name, pwd)

}