package com.marcinmoskala.minions

import org.joda.time.DateTime
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat

const val monionsFormatDateTimePattern = "yyyy-MM-dd'T'HH:mm:ssZ"

const val minionsFormatDayPattern = "yyyy-MM-dd"

fun String.parseDateTime(pattern: String = monionsFormatDateTimePattern) = DateTimeFormat.forPattern(pattern).withOffsetParsed().parseDateTime(this)

fun String.parseLocalDate(pattern: String = minionsFormatDayPattern) = DateTimeFormat.forPattern(pattern).withOffsetParsed().parseLocalDate(this)

fun LocalDate.toDateTimeAtEndOfDay(): DateTime = plusDays(1).toDateTimeAtStartOfDay().minusMillis(1)

fun LocalDate.toStandardString() = toString(minionsFormatDayPattern)

fun DateTime.toStandardString() = toString(monionsFormatDateTimePattern)

