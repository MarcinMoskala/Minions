package com.marcinmoskala.test

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import com.marcinmoskala.minions.androidutills.extra
import com.marcinmoskala.minions.androidutills.extraNullable
import kotlinx.android.synthetic.main.activity_main.*
import rx.Observable
import kotlin.properties.Delegates

open class BaseActivity(): AppCompatActivity() {}

interface MainView {
    var title: String
}

class MainActivity : BaseActivity(), MainView {

    override var title by Delegates.observable("") { prop, old, new ->
        textView.text = new
    }

    val presenter by lazy { MainPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onStart()
    }
}

class MainPresenter(val view: MainView) {

    fun onStart() {
        view.title = "Hello property"
    }
}