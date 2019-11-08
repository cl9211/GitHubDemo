package com.example.common.log

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created by CHULEI on 2019/11/8.
 */
val loggerMap = HashMap<Class<*>, Logger>()
inline val <reified T> T.logger: Logger
    get() {
        return loggerMap[T::class.java] ?: LoggerFactory.getLogger(T::class.java).apply {
            loggerMap[T::class.java] = this
        }
    }
