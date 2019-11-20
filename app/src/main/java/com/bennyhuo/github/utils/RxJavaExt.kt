package com.bennyhuo.github.utils

import rx.Observable
import rx.Subscription

/**
 * Created by CHULEI on 2019/11/19.
 */
fun <T> Observable<T>.subscribeIgnoreError(onNext: (T) -> Unit): Subscription =
        subscribe(onNext, Throwable::printStackTrace
        )