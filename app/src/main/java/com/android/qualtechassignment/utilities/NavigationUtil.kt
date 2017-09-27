package com.android.qualtechassignment.utilities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.android.qualtechassignment.CountryDetailActivity
import com.android.qualtechassignment.HomeActivity
import com.android.qualtechassignment.ProfileActivity
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

        fun openProfileActivity(activity: Activity) {
            activity.startActivity(Intent(activity, ProfileActivity::class.java))
        }

        fun openCountryDetailActivity(activity: Activity, countryResponseJson: String) {
            val bundle = Bundle()
            bundle.putSerializable(Constant.KEY_COUNTRY, countryResponseJson)
            activity.startActivity(Intent(activity, CountryDetailActivity::class.java).putExtras(bundle))
        }

    }

}