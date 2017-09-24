package com.android.qualtechassignment.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.android.qualtechassignment.myapplication.MyApplication

/**
 * Created by t on 9/23/2017.
 */
class SqliteDbHelper(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        val DB_NAME = MyApplication.getInstance()?.packageName
        val DB_VERSION = 1
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}