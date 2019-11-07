package com.example.common

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by CHULEI on 2019/11/7.
 */
class Preferences<T>(
    val context: Context,
    val name: String,
    val default: T,
    val prefName: String = "default"
): ReadWriteProperty<Any?, T> {

    private val prefs by lazy {
        context.getSharedPreferences(prefName, Context.MODE_APPEND)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {

    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        when(default) {
            is Long -> prefs.edit().putLong()
        }
    }

    private fun putPreference()

}