package com.marcinmoskala.minions.jodatime

import android.app.DatePickerDialog
import android.content.Context
import org.joda.time.LocalDate

// +-1 in month comes from uncopability between LocalDate and calendar format
fun Context.showPickDateDialog(startDay: LocalDate, function: (LocalDate) -> Unit) {
    DatePickerDialog(
            this,
            { view, year, monthOfYear, dayOfMonth -> function(LocalDate(year, monthOfYear + 1, dayOfMonth)) },
            startDay.year,
            startDay.monthOfYear - 1,
            startDay.dayOfMonth
    ).show()
}