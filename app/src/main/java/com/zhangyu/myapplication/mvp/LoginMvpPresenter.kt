package com.zhangyu.myapplication.mvp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *author：created by zhangyu
 *date：2020/4/1 0001 11
 *description
 */
class LoginMvpPresenter(private var view: ILoginMvpView) {
    private var model: LoginMvpModel? = null

    init {
        model = LoginMvpModel()
    }

    fun login(name: String, pwd: String){
        GlobalScope.launch(Dispatchers.IO) {
            model!!.login(name, pwd).let {
                withContext(Dispatchers.Main){
                  if (it.body()?.errorCode == 0){
                      view.loginSuccess()
                  }else{
                      view.loginFailed(it.body()?.errorMsg ?: "登录失败")
                  }
                }
            }
        }
    }

}