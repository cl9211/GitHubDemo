package com.bennyhuo.github.model.page

import retrofit2.adapter.rxjava.GitHubPaging
import rx.Observable

/**
 * Created by CHULEI on 2019/11/14.
 */
interface DataProvider<DataType> {
    fun getData(page: Int): Observable<GitHubPaging<DataType>>
}