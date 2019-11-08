package com.example.githubdemo.ui.login.model.account

import com.example.githubdemo.ui.login.User
import com.example.githubdemo.ui.login.network.entities.AuthorizationReq
import com.example.githubdemo.ui.login.network.entities.AuthorizationRsp
import com.example.githubdemo.ui.login.network.services.AuthService
import com.example.githubdemo.ui.login.network.services.UserService
import com.example.githubdemo.ui.login.utils.fromJson
import com.example.githubdemo.ui.login.utils.pref
import com.google.gson.Gson
import retrofit2.HttpException
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by CHULEI on 2019/11/8.
 */
object AccountManager {
    var userName by pref("")
    var passWord by pref("")
    var token by pref("")
    var authId by pref(-1)

    private var userJson by pref("")

    var currentUser: User? = null
        get() {
            if (field == null && userJson.isNotEmpty()) {
                field = Gson().fromJson<User>(userJson)
            }
            return field
        }
        set(value) {
            if (value == null) {
                userJson = ""
            } else {
                userJson = Gson().toJson(value)
            }

            field = value
        }

    fun isLoginIn(): Boolean = token.isNotEmpty()

    fun login() = AuthService.createAuthorization(AuthorizationReq())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .doOnNext {
            if (it.token.isEmpty()) throw AccountException(it)
        }
        .retryWhen {
            it.flatMap {
                if (it is AccountException) {
                    AuthService.deleteAuthorization(it.authorizationRsp.id)
                } else {
                    Observable.error(it)
                }
            }
        }
        .flatMap {
            token = it.token
            authId = it.id
            UserService.getAuthenticatedUser()
        }.map {
            currentUser = it
            notifyLogin(it)
        }

    fun logout() = AuthService.deleteAuthorization(authId)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .doOnNext {
            if (it.isSuccessful) {
                authId = -1
                token = ""
                currentUser = null
                notifyLogout()
            } else {
                throw HttpException(it)
            }
        }

    class AccountException(val authorizationRsp: AuthorizationRsp) : Exception("Already logged in.")

    private val onAccountStateChangeListener = ArrayList<OnAccountStateChangeListener>()

    private fun notifyLogin(user: User) {
        onAccountStateChangeListener.forEach {
            it.onLogin(user)
        }
    }

    private fun notifyLogout() {
        onAccountStateChangeListener.forEach {
            it.onLogout()
        }
    }
}

interface OnAccountStateChangeListener {
    fun onLogin(user: User)

    fun onLogout()
}