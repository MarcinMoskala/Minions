package com.marcinmoskala.minions

import android.content.Context

val Context.appVersion: String
    get() = packageManager.getPackageInfo(packageName, 0).versionName
