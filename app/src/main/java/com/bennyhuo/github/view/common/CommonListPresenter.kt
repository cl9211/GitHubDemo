package com.bennyhuo.github.view.common

import com.bennyhuo.github.model.page.ListPage
import com.bennyhuo.mvp.impl.BasePresenter
import rx.Subscription

/**
 * Created by CHULEI on 2019/11/15.
 */
abstract class CommonListPresenter<DataType, out View : CommonListFragment<DataType, CommonListPresenter<DataType, View>>> : BasePresenter<View>() {

    abstract val listPage: ListPage<DataType>

    private val subscriptionList = ArrayList<Subscription>()
    private var firstInView = true

    fun initData() {
        listPage.loadFromFirst()
                .subscribe({
                    if (it.isEmpty()) view.onDataInitWithNothing() else view.onDataInit(it)
                }, {
                    view.onDataInitWithError(it.message ?: it.toString())
                }).let(subscriptionList::add)
    }

    fun refreshData() {
        listPage.loadFromFirst()
                .subscribe({
                    if (it.isEmpty()) view.onDataInitWithNothing() else view.onDataRefresh(it)
                }, {
                    view.onDataRefreshWithError(it.message ?: it.toString())
                }).let(subscriptionList::add)
    }

    fun loadMore() {
        listPage.loadMore().subscribe({
            view.onMoreDataLoaded(it)
        }, {
            view.onMoreDataLoadedWithError(it.message ?: it.toString())
        }).let(subscriptionList::add)
    }

    override fun onDestroy() {
        super.onDestroy()
        subscriptionList.forEach(Subscription::unsubscribe)
        subscriptionList.clear()
    }

    override fun onResume() {
        super.onResume()
        if (!firstInView) {
            refreshData()
        }

        firstInView = false
    }
}