package com.bennyhuo.dsl.layout.v1

import android.view.View
import android.view.ViewGroup
import kotlin.annotation.AnnotationTarget.*


/**
 * Created by CHULEI on 2019/11/13.
 */
@DslViewMarker
interface DslViewParent<out P : ViewGroup.MarginLayoutParams> {
    val <T : View> T.lparams: P
        get() = layoutParams as P
}

@DslMarker
@Target(CLASS, TYPE, TYPEALIAS)
annotation class DslViewMarker