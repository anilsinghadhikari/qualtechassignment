package com.android.watchoveryou.utility

import android.content.Context
import android.content.SharedPreferences
import com.android.qualtechassignment.myapplication.MyApplication
import com.android.qualtechassignment.utilities.Utility

/**
 * Created by T on 15-04-2016.
 */
object PrefUtils {

    private val MyPREFERENCES = Utility.getPackageName() + "_pref"

    fun setValue(key: String, value: String) {
        preference.edit().putString(key, value).commit()
    }

    fun setValue(key: String, value: Int) {
        preference.edit().putInt(key, value).commit()
    }

    fun setValue(key: String, value: Boolean) {
        preference.edit().putBoolean(key, value).commit()
    }


    fun setValueToBoolPref(key: String, value: Boolean) {
        preference.edit().putBoolean(key, value).commit()
    }

    private val preference: SharedPreferences
        get() = MyApplication.getInstance()?.getApplicationContext()?.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)!!

    fun getValue(key: String, defaultValue: String): String? {
        return preference.getString(key, defaultValue)
    }

    fun getValue(key: String, defaultValue: Boolean): Boolean {
        return preference.getBoolean(key, defaultValue)
    }

    fun getValueFromInt(key: String, defaultValue: Int): Int {
        return preference.getInt(key, defaultValue)
    }




}
