package com.example.githubdemo.ui.login.utils

import com.google.gson.Gson

/**
 * Created by CHULEI on 2019/11/8.
 */
inline fun <reified T> Gson.fromJson(json: String) = fromJson(json, T::class.java)