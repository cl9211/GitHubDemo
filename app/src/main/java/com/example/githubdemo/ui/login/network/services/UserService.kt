package com.example.githubdemo.ui.login.network.services

import com.example.githubdemo.ui.login.User
import com.example.githubdemo.ui.login.network.retrofit
import retrofit2.http.GET
import rx.Observable

/**
 * Created by CHULEI on 2019/11/8.
 */
interface UserApi {
    @GET("/user")
    fun getAuthenticatedUser(): Observable<User>
}

object UserService : UserApi by retrofit.create(UserApi::class.java)