package com.android.qualtechassignment.utlities

import android.app.Activity
import android.content.Intent
import com.android.qualtechassignment.HomeActivity
import com.android.qualtechassignment.SignUpActivity

/**
 * Created by t on 9/23/2017.
 */
class NavigationUtil {

    companion object {
        fun openHomeActivity(activity: Activity) {
            activity.startActivity(Intent(activity, HomeActivity::class.java))
        }

        fun openSignUpActivity(activity: Activity) {
            activity.startActivity(Intent(activity, SignUpActivity::class.java))
        }

    }

}