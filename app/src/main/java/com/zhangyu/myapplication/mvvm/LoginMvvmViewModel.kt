package com.zhangyu.myapplication.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zhangyu.myapplication.entity.UserData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *author：created by zhangyu
 *date：2020/4/1 0001 14
 *description
 */
class LoginMvvmViewModel(var model:LoginMvvmModel): ViewModel() {

    var userData: MutableLiveData<UserData> = MutableLiveData()
    var errorMsg: MutableLiveData<String> = MutableLiveData()
    fun login(name: String, pwd: String){
        GlobalScope.launch(Dispatchers.IO) {
            model.login(name, pwd).let {
                withContext(Dispatchers.Main){
                    if (it.body()?.errorCode == 0){
                        userData.value = it.body()?.data
                    }else{
                        errorMsg.value = it.body()?.errorMsg
                    }
                }

            }
        }
    }

}