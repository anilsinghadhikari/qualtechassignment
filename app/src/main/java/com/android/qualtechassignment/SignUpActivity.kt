package com.android.qualtechassignment

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.android.qualtechassignment.data.UserBean
import com.android.qualtechassignment.mywidgets.CustomSubmitButton
import com.android.qualtechassignment.presenters.SignUpPresenterImpl
import com.android.qualtechassignment.utlities.ErrorMsg
import com.android.qualtechassignment.utlities.NavigationUtil
import com.android.qualtechassignment.utlities.Utility
import com.android.qualtechassignment.views.SignUpView
import com.android.watchoveryou.utility.AnimUtil
import com.android.watchoveryou.utility.ErrorViewUtil
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseActivity(), SignUpView {

    override fun setContent() {
        setContentView(R.layout.activity_sign_up)
    }

    override fun navigateToHomeActivity() {
        NavigationUtil.openHomeActivity(this)
    }

    override fun getToolBarTitle(): String {
        return Utility.getStringFromResource(R.string.title_signup)
    }


    override fun showProgress() {
        signUpButton.showProgress("Signing up..")
    }

    override fun hideProgress() {
        signUpButton.hideProgress()
    }

    override fun showErrorMsg(errorMsg: String) {
        ErrorViewUtil.showErrorDialog(this, ErrorMsg.ERROR_TITLE, errorMsg)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val signUpPresenterImpl = SignUpPresenterImpl(this)
        signUpButton.setCustomClickListener(object : CustomSubmitButton.OnCustomClickLister {
            override fun onButtonClick() {
                signUpPresenterImpl.validateUserData(UserBean(signUpWidget.getUserName(), signUpWidget.getEmailID(), signUpWidget.getMobileNo()))

            }

        })


    }


}
