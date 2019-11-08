package com.example.githubdemo.ui.login.presenter

import com.example.githubdemo.ui.login.model.account.AccountManager
import com.example.githubdemo.ui.login.view.LoginActivity
import com.example.mvp.impl.BasePresenter

/**
 * Created by CHULEI on 2019/11/8.
 */
class LoginPresenter : BasePresenter<LoginActivity>() {
    fun doLogin(name: String, passWord: String) {
        AccountManager.userName = name
        AccountManager.passWord = passWord
        view.onLoginStart()
        AccountManager.login().subscribe({
            view.onLoginSuccess()
        }, {
            view.onLoginError(it)
        })
    }

    fun checkUserName(name: String): Boolean {
        return true
    }

    fun checkPassWord(passWord: String): Boolean {
        return true
    }

    override fun onResume() {
        super.onResume()
        view.onDataInit(AccountManager.userName, AccountManager.passWord)
    }
}