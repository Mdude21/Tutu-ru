package ru.mdude21.tutu.domain

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class DateFormatterTest{

    @Test
    fun reformatDateTest() {
        val excepted = "13.02.2022"
        assertEquals(excepted, DateFormatter().reformatDate("2022-02-13T09:47:11Z"))
    }

    @Test
    fun printDateTest(){
        val excepted = "Updated at 13.02.2022"
        assertEquals(excepted, DateFormatter().printDate("2022-02-13T09:47:11Z"))
    }


}