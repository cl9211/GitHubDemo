package com.bennyhuo.github.utils

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by CHULEI on 2019/11/13.
 */
fun AppCompatActivity.showFragment(containerId: Int, clazz: Class<out Fragment>, vararg args: Pair<String, String>) {
    supportFragmentManager.beginTransaction()
            .replace(containerId, clazz.newInstance().apply {
                arguments = Bundle().apply {
                    args.forEach {
                        putString(it.first, it.second)
                    }
                }
            }, clazz.name).commitAllowingStateLoss()
}