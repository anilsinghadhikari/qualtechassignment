package com.android.qualtechassignment

import android.os.Bundle
import com.android.qualtechassignment.utlities.Utility

class ProfileActivity : BaseActivity() {
    override fun setContent() {
        setContentView(R.layout.activity_profile)

    }

    override fun getToolBarTitle(): String {

        return Utility.getStringFromResource(R.string.title_profile)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }
}
