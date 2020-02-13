package com.jiyoung.kotilnexample.ui

import android.util.Log

object Log {
    val TAG = "TEST"

    fun e(message : String){

        var tag = ""
        val temp = Throwable().stackTrace[1].className
        if (temp != null) {
            val lastDotPos = temp.lastIndexOf(".")
            tag = temp.substring(lastDotPos + 1)
        }
        val methodName = Throwable().stackTrace[1]
            .methodName
        val lineNumber = Throwable().stackTrace[1].lineNumber

        Log.e(TAG, "[$tag] [$methodName()::$lineNumber] >> $message")
    }

    fun d(message : String) {
        var tag = ""
        val temp = Throwable().stackTrace[1].className
        if (temp != null) {
            val lastDotPos = temp.lastIndexOf(".")
            tag = temp.substring(lastDotPos + 1)
        }
        val methodName = Throwable().stackTrace[1]
            .methodName
        val lineNumber = Throwable().stackTrace[1].lineNumber

        Log.e(TAG, "[$tag] [$methodName()::$lineNumber] >> $message")
    }
}