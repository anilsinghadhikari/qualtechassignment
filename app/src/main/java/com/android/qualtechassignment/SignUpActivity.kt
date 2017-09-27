package com.android.qualtechassignment

import android.os.Bundle
import com.android.qualtechassignment.data.UserBean
import com.android.qualtechassignment.mywidgets.CustomSubmitButton
import com.android.qualtechassignment.presenters.SignUpPresenterImpl
import com.android.qualtechassignment.utilities.ErrorMsg
import com.android.qualtechassignment.utilities.NavigationUtil
import com.android.qualtechassignment.utilities.Utility
import com.android.qualtechassignment.views.SignUpView
import com.android.watchoveryou.utility.ErrorViewUtil
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseActivity(), SignUpView {

    override fun setContent() {
        setContentView(R.layout.activity_sign_up)
    }

    override fun navigateToHomeActivity() {
        ErrorViewUtil.showToast(this@SignUpActivity, "Profile created successfully.")
        NavigationUtil.openHomeActivity(this)
        finish()
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
