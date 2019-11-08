package com.example.githubdemo.ui.login

import android.app.Application
import android.content.ContextWrapper

/**
 * Created by CHULEI on 2019/11/7.
 */

private lateinit var INSTANCE: Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}

object AppContext: ContextWrapper(INSTANCE)