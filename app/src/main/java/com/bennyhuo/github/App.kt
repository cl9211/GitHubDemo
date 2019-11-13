package com.bennyhuo.github

import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import android.support.multidex.MultiDex

private lateinit var INSTANCE: Application

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    override fun attachBaseContext(base: Context?) {
        MultiDex.install(base)
        super.attachBaseContext(base)
    }
}

object AppContext: ContextWrapper(INSTANCE)