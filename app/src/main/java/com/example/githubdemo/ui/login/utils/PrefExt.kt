package com.example.githubdemo.ui.login.utils

import com.example.common.sharedpreferences.Preferences
import com.example.githubdemo.ui.login.AppContext
import kotlin.reflect.jvm.jvmName


/**
 * Created by CHULEI on 2019/11/8.
 */
inline fun <reified R, T> R.pref(default: T) = Preferences(AppContext, "", default, R::class.jvmName)