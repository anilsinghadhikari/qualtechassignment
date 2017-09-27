package com.android.qualtechassignment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.android.qualtechassignment.utilities.NavigationUtil
import com.android.qualtechassignment.utilities.Utility

class SplashActivity : AppCompatActivity() {

    private val DURATION: Long = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var handler = Handler()
        var r = Runnable {
            if (Utility.isUserLoggedInOrSignedUp()) {
                NavigationUtil.openHomeActivity(this)
            } else {
                NavigationUtil.openSignUpActivity(this)
            }
            finish()
        }
        handler?.postDelayed(r, DURATION)
    }


}
