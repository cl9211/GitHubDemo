package com.bennyhuo.github.network

import com.bennyhuo.github.AppContext
import org.jetbrains.anko.connectivityManager

/**
 * Created by CHULEI on 2019/11/20.
 */
object Network {
    fun isAvailable(): Boolean = AppContext.connectivityManager.activeNetworkInfo?.isAvailable ?: false
}