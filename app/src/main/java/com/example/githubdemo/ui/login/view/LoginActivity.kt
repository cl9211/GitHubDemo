package com.example.githubdemo.ui.login.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.example.common.ext.otherwise
import com.example.common.ext.yes
import com.example.githubdemo.R
import com.example.githubdemo.ui.login.presenter.LoginPresenter
import com.example.githubdemo.ui.login.utils.hideSoftInput
import com.example.mvp.impl.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity<LoginPresenter>() {
    private val signInButton by lazy {
        findViewById<Button>(R.id.signInButton)
    }
    private val userName by lazy {
        findViewById<EditText>(R.id.username)
    }
    private val passWord by lazy {
        findViewById<EditText>(R.id.password)
    }
    private val loginForm by lazy {
        findViewById<LinearLayout>(R.id.loginForm)
    }
    private val loginProgress by lazy {
        findViewById<ProgressBar>(R.id.loginProgress)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signInButton.setOnClickListener {
            presenter.checkUserName(userName.text.toString())
                .yes {
                    presenter.checkPassWord(passWord.text.toString()).yes {
                        hideSoftInput()

                        presenter.doLogin(userName.text.toString(), password.text.toString())
                    }.otherwise {
                        showTips(password, "密码不合法")
                    }
                }.otherwise {
                    showTips(userName, "用户名不合法")
                }
        }
    }

    private fun showTips(view: EditText, tips: String) {
        view.requestFocus()
        view.error = tips
    }

    fun onLoginSuccess() {
        Log.e("tag", Thread.currentThread().name)
        showProgress(false)
        toast("登录成功")
    }

    fun onLoginError(e: Throwable) {
        e.printStackTrace()
        showProgress(false)
        toast("登陆失败")
    }

    fun onLoginStart() {
        showProgress(true)
    }

    fun onDataInit(name: String, passwd: String) {
        userName.setText(name)
        passWord.setText(passwd)
    }

    private fun showProgress(show: Boolean) {
        val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime)
        loginForm.animate().setDuration(shortAnimTime.toLong()).alpha(
            (if (show) 0 else 1).toFloat()
        ).setListener(
            object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    loginForm.visibility = if (show) View.GONE else View.VISIBLE
                }

            }
        )

        loginProgress.animate().setDuration(shortAnimTime.toLong()).alpha(
            (if (show) 1 else 0).toFloat()
        ).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                loginProgress.visibility = if (show) View.VISIBLE else View.GONE
            }
        })

    }
}

