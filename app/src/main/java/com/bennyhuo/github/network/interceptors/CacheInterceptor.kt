package com.bennyhuo.github.network.interceptors

import com.bennyhuo.common.log.logger
import com.bennyhuo.github.common.ext.no
import com.bennyhuo.github.common.ext.otherwise
import com.bennyhuo.github.common.ext.yes
import com.bennyhuo.github.network.FORCE_NETWORK
import com.bennyhuo.github.network.Network
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by CHULEI on 2019/11/20.
 */
class CacheInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = Network.isAvailable().no {
            request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build()
        }.otherwise {
            request.url().queryParameter(FORCE_NETWORK)?.toBoolean()?.let {
                it.yes {
                    request.newBuilder().cacheControl(CacheControl.Builder().noCache().build()).build()
                }.otherwise {
                    request
                }
            } ?: request
        }

        request = request.newBuilder().url(request.url().newBuilder().removeAllQueryParameters(FORCE_NETWORK).build()).build()
        return chain.proceed(request).also { response ->
            logger.error("Cache: ${response.cacheResponse()}, Network: ${response.networkResponse()}")
        }
    }
}