package com.example.githubdemo.ui.login

import com.example.common.log.logger
import com.example.githubdemo.ui.login.utils.deviceId


object Configs {

    object Account{
        val SCOPES = listOf("user", "repo", "notifications", "gist", "admin:org")
        const val clientId = "Iv1.6dd8c3e827b2e934"
        const val clientSecret = "1c1c32c1d324b397cba0829b16e34de824fca41e"
        const val note = "kotliner.cn"
        const val noteUrl = "http://www.kotliner.cn"

        val fingerPrint by lazy {
            (AppContext.deviceId + clientId).also { logger.info("fingerPrint: "+it) }
        }
    }

}