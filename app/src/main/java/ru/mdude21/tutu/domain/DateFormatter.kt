package ru.mdude21.tutu.domain

import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {

    fun reformatDate(dateTime: String): String {
        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH)

        return dateFormat.format(parser.parse(dateTime))
    }

    fun printDate(dateTime: String): String {
        return ("Updated at " + reformatDate(dateTime))
    }
}