package com.jiyoung.kotilnexample.common

import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

object DateTimeHelper {
    fun formatDateTime(dateTimeStr: String): String {
        // 현재 시간과 비교할 대상 시간 파싱
        val targetTime = ZonedDateTime.parse(dateTimeStr)
        val now = ZonedDateTime.now(ZoneId.systemDefault())

        // 시간 차이 계산
        val minutesAgo = ChronoUnit.MINUTES.between(targetTime, now)
        val hoursAgo = ChronoUnit.HOURS.between(targetTime, now)
        val daysAgo = ChronoUnit.DAYS.between(targetTime, now)

        // 조건에 따라 다른 문자열 포맷 반환
        return when {
            minutesAgo < 60 -> "$minutesAgo 분 전"
            hoursAgo < 24 -> "$hoursAgo 시간 전"
            daysAgo == 1L -> "하루 전"
            else -> targetTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        }
    }
}