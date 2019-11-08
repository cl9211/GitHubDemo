package com.example.githubdemo.ui.login.network.interceptors

import android.util.Base64
import com.example.githubdemo.ui.login.model.account.AccountManager
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by CHULEI on 2019/11/8.
 */
class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        return chain.proceed(original.newBuilder()
            .apply {
                when {
                    original.url().pathSegments().contains("authorizations") -> {
                        val userCredentials =
                            AccountManager.userName + ":" + AccountManager.passWord
                        val auth = "Basic" + String(
                            Base64.encode(
                                userCredentials.toByteArray(),
                                Base64.DEFAULT
                            )
                        ).trim()

                        header("Authorization", auth)
                    }

                    AccountManager.isLoginIn() -> {
                        val auth = "Token" + AccountManager.token
                        header("Authorization", auth)
                    }

                    else ->
                        removeHeader("Authorizaiont")
                }
            }
            .build()
        )
    }

}