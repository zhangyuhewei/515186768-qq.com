package com.zhangyu.myapplication.mvc

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zhangyu.myapplication.R
import kotlinx.android.synthetic.main.activity_login_mvc.*
import org.jetbrains.anko.toast

class LoginMvcActivity : AppCompatActivity(), IView {

    private var controller: LoginController? = null
    private var model: LoginModel? = null

    companion object {
        fun startActivity(context: Context){
            context.startActivity(Intent(context, LoginMvcActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_mvc)


        model = LoginModel(this)
        controller = LoginController(model!!)
        controller?.let { setController(it) }
        btn_login.setOnClickListener{
            var name = edit_name.text.toString()
            var pwd = edit_password.text.toString()
            if (name.isBlank() || pwd.isBlank()){
                this.toast("用户名和密码不能为空")
            }else{
                controller?.login(name, pwd)
            }
        }
    }

    override fun setController(controller: LoginController) {
       this.controller = controller
    }

    override fun loading() {
        TODO("Not yet implemented")
    }

    override fun loginSuccess() {
        this.toast("登录成功")
    }

    override fun loginFailed(msg: String) {
        this.toast(msg)
    }
}
