package com.android.watchoveryou.utility

import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.EditText
import com.android.qualtechassignment.R
import com.android.qualtechassignment.myapplication.MyApplication

/**
 * Created by qainfotech on 7/4/17.
 */

object AnimUtil {

    @JvmOverloads
    fun shakeMyView(v: View, hintMsg: String? = null) {

        if (!TextUtils.isEmpty(hintMsg)) {
            val editText = v as EditText
            editText.hint = hintMsg
            editText.setHintTextColor(ContextCompat.getColor(MyApplication.getInstance()?.applicationContext, R.color.hintcolor_validation))
        }
        val shake = AnimationUtils.loadAnimation(MyApplication.getInstance()?.applicationContext, R.anim.anim_shake)
        v.startAnimation(shake)
        v.requestFocus()
    }
}
