package com.zhangyu.myapplication.mvp

/**
 *author：created by zhangyu
 *date：2020/4/1 0001 11
 *description
 */
interface ILoginMvpView {
    fun loginSuccess()
    fun loginFailed(msg: String)

}