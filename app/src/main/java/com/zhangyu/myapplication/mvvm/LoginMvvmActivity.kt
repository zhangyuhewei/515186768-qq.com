package com.zhangyu.myapplication.mvvm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.zhangyu.myapplication.R
import com.zhangyu.myapplication.databinding.ActivityLoginMvvmBinding
import org.jetbrains.anko.toast

class LoginMvvmActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this, LoginMvvmFactory(LoginMvvmModel()))
            .get(LoginMvvmViewModel::class.java)
    }
    private var dataBinding:ActivityLoginMvvmBinding? = null

    companion object{
        fun startActivity(context:Context){
            context.startActivity(Intent(context, LoginMvvmActivity::class.java))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_mvvm)
        dataBinding?.lifecycleOwner = this
        dataBinding?.holder = this

        viewModel.userData.observeForever {
            this.toast("登录成功 " + it.nickname)
        }
        viewModel.errorMsg.observeForever {
            this.toast("登录失败 " + viewModel.errorMsg.value)
        }
    }

    fun login(view: View){
        var name = dataBinding?.name.toString()
        var pwd = dataBinding?.password.toString()
        if (name.isBlank() || pwd.isBlank()){
            this.toast("用户名和密码不能为空")
        }else{
            viewModel.login(name, pwd)
        }

    }

}
