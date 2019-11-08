package com.example.githubdemo.ui.login.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by CHULEI on 2019/11/8.
 */
class AcceptInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        return chain.proceed(original.newBuilder()
            .apply {
                header(
                    "accept",
                    "application/vnd.github.v3.full+json, ${original.header("accept") ?: ""}"
                )
            }
            .build())
    }
}