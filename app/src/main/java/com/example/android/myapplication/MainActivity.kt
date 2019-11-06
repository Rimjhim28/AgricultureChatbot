package com.example.android.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getResponse()
    }

    fun getResponse() {
        Log.v("Anubhav" , "getResponseCalled")
        GetResponseAsync().execute("param")
    }
}
