package com.example.githubdemo.ui.login.utils

import android.content.Context
import android.provider.Settings

/**
 * Created by CHULEI on 2019/11/8.
 */
val Context.deviceId: String
    get() = Settings.Secure.getString(
        contentResolver, Settings.Secure.ANDROID_ID
    )