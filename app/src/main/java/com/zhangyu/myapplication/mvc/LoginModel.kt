package com.zhangyu.myapplication.mvc

import com.zhangyu.myapplication.network.RetrofitManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *author：created by zhangyu
 *date：2020/4/1 0001 08
 *description
 */
class LoginModel(private var view: IView?){

      suspend fun login(name: String, pwd: String){
            RetrofitManager.apiService.login(name, pwd).let {
                withContext(Dispatchers.Main){
                    if (it.body()?.errorCode == 0){
                        view?.loginSuccess()
                    }else{
                        view?.loginFailed(it.body()?.errorMsg ?: "登录失败")
                    }
                }
        }

    }
}