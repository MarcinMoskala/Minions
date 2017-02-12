package com.marcinmoskala.minions.jodatime

import android.app.TimePickerDialog
import android.content.Context
import android.view.View
import org.joda.time.LocalTime

fun Context.showPickTimeDialog(time: LocalTime, function: (LocalTime) -> Unit) {
    TimePickerDialog(
            this,
            { view: View, hour: Int, minute: Int -> function(LocalTime(hour, minute)) },
            time.hourOfDay,
            time.minuteOfHour,
            true
    ).show()
}