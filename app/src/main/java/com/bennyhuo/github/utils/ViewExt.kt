package com.bennyhuo.github.utils

import android.widget.TextView
import com.zzhoujay.richtext.RichText

/**
 * Created by CHULEI on 2019/11/13.
 */
var TextView.markdownText: String
    set(value) {
        RichText.fromMarkdown(value).into(this)
    }
    get() = text.toString()