package com.example.githubdemo.ui.login.network.services

import com.example.githubdemo.ui.login.Configs
import com.example.githubdemo.ui.login.network.entities.AuthorizationReq
import com.example.githubdemo.ui.login.network.entities.AuthorizationRsp
import com.example.githubdemo.ui.login.network.retrofit
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.PUT
import retrofit2.http.Path
import rx.Observable

/**
 * Created by CHULEI on 2019/11/8.
 */
interface AuthApi {

    @PUT("/authorizations/clients/${Configs.Account.clientId}/{fingerPrint}")
    fun createAuthorization(@Body req: AuthorizationReq, @Path("fingerPrint") fingerPrint: String = Configs.Account.fingerPrint)
            : Observable<AuthorizationRsp>

    @DELETE("/authorizations/{id}")
    fun deleteAuthorization(@Path("id") id: Int): Observable<Response<Any>>

}

object AuthService : AuthApi by retrofit.create(AuthApi::class.java)