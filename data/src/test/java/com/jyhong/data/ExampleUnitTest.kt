package com.jyhong.data

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun solution_execute() {

    }

    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        var start = 0
        while (start < priorities.size - 1) {
            val next = priorities[start + 1]
            if (priorities[start] < next) {
                start
            }
            start++
        }
        return answer
    }

    fun checkPriority() {

    }
}