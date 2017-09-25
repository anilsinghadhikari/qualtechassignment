package com.android.qualtechassignment.utlities

import android.app.ProgressDialog
import android.content.Context
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.android.qualtechassignment.myapplication.MyApplication

/**
 * Created by qainfotech on 7/4/17.
 */

object Utility {
    private val progressDialog: ProgressDialog? = null

    fun validEmail(email: String): Boolean {
        return if (TextUtils.isEmpty(email)) false else android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidNo(mobileNo: String?): Boolean {
        if (TextUtils.isEmpty(mobileNo))
            return false
        return mobileNo?.length == 10
    }

    fun closeKeyBoard(view: View?) {
        if (view != null) {
            val imm = MyApplication.Companion.getInstance()?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun getArrayFromStringResourse(res_array_id: Int): Array<out String>? {
        return MyApplication.Companion.getInstance()?.getApplicationContext()?.getResources()?.getStringArray(res_array_id)

    }

    fun getStringFromResource(resID: Int): String {
        val applicationContext = MyApplication.getInstance()?.applicationContext
        return applicationContext?.resources?.getString(resID).toString()
    }
}
