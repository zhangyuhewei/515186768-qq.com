package com.zhangyu.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.zhangyu.myapplication.databinding.ActivityMainBinding
import com.zhangyu.myapplication.mvc.LoginMvcActivity
import com.zhangyu.myapplication.mvp.LoginMvpActivity
import com.zhangyu.myapplication.mvvm.LoginMvvmActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var dataBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        dataBinding.lifecycleOwner = this
        dataBinding.holder = this

    }

    fun mvcClick(view: View){
        LoginMvcActivity.startActivity(this)
    }

    fun mvpClick(view: View){
        LoginMvpActivity.startActivity(this)
    }

    fun mvvmClick(view: View){
        LoginMvvmActivity.startActivity(this)
    }
}
