package com.android.qualtechassignment.myapplication

import android.app.Application

/**
 * Created by t on 9/23/2017.
 */
class MyApplication : Application() {


    companion object {
        private var myInstance: Application? = null

        fun getInstance(): Application? {
            return myInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        myInstance =this
    }
}