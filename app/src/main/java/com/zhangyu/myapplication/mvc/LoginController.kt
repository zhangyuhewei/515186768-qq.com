package com.zhangyu.myapplication.mvc

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 *author：created by zhangyu
 *date：2020/4/1 0001 09
 *description
 */
class LoginController(var loinModel: LoginModel) {

    fun login(name: String, pwd: String){
        GlobalScope.launch(Dispatchers.IO) {
            loinModel?.login(name, pwd)
        }
    }
}