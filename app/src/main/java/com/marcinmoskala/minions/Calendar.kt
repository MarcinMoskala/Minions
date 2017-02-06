package com.marcinmoskala.minions

import org.joda.time.DateTime
import org.joda.time.Days
import org.joda.time.LocalDate

val today = LocalDate()
val tomorrow = LocalDate().plusDays(1)!!
val yesterday = LocalDate().minusDays(1)!!

val now: DateTime
    get() = DateTime()

fun listOfDays(startDate: LocalDate, endDate: LocalDate): List<LocalDate> {
    if (startDate.isAfter(endDate)) return listOf()
    val daysBetween = Days.daysBetween(startDate, endDate).days
    return (0..daysBetween).map { LocalDate(startDate).plusDays(it) }
}