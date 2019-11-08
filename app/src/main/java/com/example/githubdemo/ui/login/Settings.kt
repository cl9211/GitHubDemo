package com.example.githubdemo.ui.login

import com.example.common.sharedpreferences.Preferences

/**
 * Created by CHULEI on 2019/11/8.
 */
object Settings {
    var email: String by Preferences(AppContext, "email", "")
    var password: String by Preferences(
        AppContext,
        "password",
        ""
    )
}