package com.zhangyu.myapplication.network

import com.zhangyu.myapplication.entity.UserEntity
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 *author：created by zhangyu
 *date：2020/3/27 0027 15
 *description
 */
interface ApiService {

    //测试登录
    @POST("/user/login")
    @FormUrlEncoded
    suspend fun login(@Field("username")username: String,
                      @Field("password") password: String): Response<UserEntity>

}