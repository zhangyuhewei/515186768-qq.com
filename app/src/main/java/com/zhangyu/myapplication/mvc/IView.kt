package com.zhangyu.myapplication.mvc

/**
 *author：created by zhangyu
 *date：2020/4/1 0001 10
 *description
 */
interface IView {
    fun setController(controller: LoginController)
    fun loading()
    fun loginSuccess()
    fun loginFailed(msg: String)
}