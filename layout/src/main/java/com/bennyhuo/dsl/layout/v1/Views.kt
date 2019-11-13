package com.bennyhuo.dsl.layout.v1

import android.app.Activity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout

/**
 * Created by CHULEI on 2019/11/13.
 */
inline fun <reified T : ViewGroup> T.linearLayout(init: _LinearLayout.() -> Unit) {
    _LinearLayout(context).also(this::addView).also(init)
}

inline fun <reified T : ViewGroup> T.frameLayout(init: _FrameLayout.() -> Unit) {
    _FrameLayout(context).also(this::addView).also(init)
}

inline fun <reified T : ViewGroup> T.button(init: Button.() -> Unit) {
    Button(context).also(this::addView).also(init)
}

inline fun <reified T : ViewGroup> T.verticalLayout(init: _LinearLayout.() -> Unit) {
    _LinearLayout(context).also(this::addView).apply {
        orientation = LinearLayout.VERTICAL
        init()
    }
}

inline fun <reified T : Activity> T.linearLayout(init: _LinearLayout.() -> Unit) {
    _LinearLayout(this).also(this::setContentView).also(init)
}

inline fun <reified T : Activity> T.frameLayout(init: _FrameLayout.() -> Unit) {
    _FrameLayout(this).also(this::setContentView).also(init)
}

inline fun <reified T : Activity> T.button(init: Button.() -> Unit) {
    Button(this).also(this::setContentView).also(init)
}

inline fun <reified T : Activity> T.verticalLayout(init: _LinearLayout.() -> Unit) {
    _LinearLayout(this).also(this::setContentView).apply {
        orientation = LinearLayout.VERTICAL
        init()
    }
}



