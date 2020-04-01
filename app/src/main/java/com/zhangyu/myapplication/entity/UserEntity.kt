package com.zhangyu.myapplication.entity

/**
 *author：created by zhangyu
 *date：2020/3/27 0027 15
 *description
 */
data class UserEntity(
    val `data`: UserData,
    val errorCode: Int,
    val errorMsg: String
)

data class UserData(
    val admin: Boolean,
    val chapterTops: List<Any>,
    val collectIds: List<Any>,
    val email: String,
    val icon: String,
    val id: Int,
    val nickname: String,
    val password: String,
    val token: String,
    val type: Int,
    val username: String
)