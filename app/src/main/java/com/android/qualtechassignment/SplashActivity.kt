package com.android.qualtechassignment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.android.qualtechassignment.utlities.NavigationUtil

class SplashActivity : AppCompatActivity() {

    var r: Runnable? = null
    var handler: Handler? = null
    private val DURATION: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handler = Handler()
        var r = Runnable {
            NavigationUtil.openSignUpActivity(this)
            finish()
        }
        handler?.postDelayed(r, DURATION)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        // remove the callbacks if back button is pressed before firing this runnable
        handler?.removeCallbacks(r)
    }
}
