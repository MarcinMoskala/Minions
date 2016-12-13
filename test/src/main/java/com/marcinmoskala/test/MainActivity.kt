package com.marcinmoskala.test

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.marcinmoskala.minions.bindToPreferenceField
import com.marcinmoskala.minions.preferences
import com.marcinmoskala.minions.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
