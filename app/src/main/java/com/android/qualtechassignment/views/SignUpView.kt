package com.android.qualtechassignment.views

/**
 * Created by t on 9/23/2017.
 */
interface SignUpView {
    fun showProgress()
    fun hideProgress()
    fun showErrorMsg(errorMsg: String)
    fun navigateToHomeActivity()

}