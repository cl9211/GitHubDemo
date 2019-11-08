package com.example.mvp

/**
 * Created by CHULEI on 2019/11/7.
 */
interface IPresenter<out View : IMvpView<IPresenter<View>>> : ILifecycle {
    val view: View
}

interface IMvpView<out Presenter : IPresenter<IMvpView<Presenter>>> : ILifecycle {
    val presenter: Presenter
}