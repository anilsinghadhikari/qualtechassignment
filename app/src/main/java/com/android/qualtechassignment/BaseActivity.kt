package com.android.qualtechassignment

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_toolbar.*

/**
 * Created by t on 9/23/2017.
 * This activity takes care of setting up tool bar for all concreate activity
 */
abstract class BaseActivity : AppCompatActivity() {
//    val toolbar: Toolbar by bind(R.id.toolbar)

    /*open abstract fun getContent(): Int

    */

    open abstract fun setContent()

    open abstract fun getToolBarTitle(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(getContent())
        setContent()
        setUpToolbar()
    }

    fun setUpToolbar() {
        setSupportActionBar(toolbar)
        val supportActionBar = supportActionBar
        if (this is SignUpActivity || this is HomeActivity) {
            supportActionBar?.setHomeButtonEnabled(false)
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        } else {
            supportActionBar?.setHomeButtonEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        //        supportActionBar.setDefaultDisplayHomeAsUpEnabled(true);
//        setTitle(getToolBarTitle())
    }


}