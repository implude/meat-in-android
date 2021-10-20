package app.meatin.util

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

val defaultDateFormatter = SimpleDateFormat("yyyy년 M월 d일", Locale.KOREA)
fun Long.toDate(): Date =
    Calendar.getInstance().apply {
        timeInMillis = this@toDate
    }.time