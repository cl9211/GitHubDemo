package com.example.common.ext

import android.util.Log
import java.io.File

/**
 * Created by CHULEI on 2019/11/8.
 */
private const val TAG = "FileExt"

fun File.ensureDir(): Boolean {
    try {
        isDirectory.no {
            isFile.yes {
                delete()
            }
            return mkdirs()
        }
    } catch (e: Exception) {
        Log.w("tag", e.message)
    }
    return false
}