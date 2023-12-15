package com.jiyoung.kotilnexample

import java.text.SimpleDateFormat

object AppUtils {
    fun getDate(dateString: String): String {

        try {
            val format1 = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'")
            val date = format1.parse(dateString)
            val sdf = SimpleDateFormat("MMM d, yyyy")
            return sdf.format(date)
        } catch (ex: Exception) {
            ex.printStackTrace()
            return "xx"
        }

    }

    fun getTime(dateString: String): String {
        return try {
            val format1 = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'")
            val date = format1.parse(dateString)
            val sdf = SimpleDateFormat("h:mm a")
            sdf.format(date)
        } catch (ex: Exception) {
            ex.printStackTrace()
            "xx"
        }

    }
}