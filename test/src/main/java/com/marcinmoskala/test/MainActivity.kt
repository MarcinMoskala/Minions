package com.marcinmoskala.test

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import com.marcinmoskala.minions.extra
import com.marcinmoskala.minions.extraNullable


class MainActivity : AppCompatActivity() {

//    val a: Parcelable by extra("A")
//    val b: Parcelable? by extraNullable("A")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
