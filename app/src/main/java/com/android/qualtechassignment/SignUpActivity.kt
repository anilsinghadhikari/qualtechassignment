package com.android.qualtechassignment

import android.os.Bundle
import com.android.qualtechassignment.data.UserBean
import com.android.qualtechassignment.presenters.SignUpPresenterImpl
import com.android.qualtechassignment.utlities.NavigationUtil
import com.android.qualtechassignment.utlities.Utility
import com.android.qualtechassignment.views.SignUpView
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

    }

    //    private val signUpButtobn: CustomSubmitButton by bind(R.id.signUpButtobn)
//    private val signUpWidget: SignUpWidget by bind(R.id.signUpWidget)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val signUpPresenterImpl = SignUpPresenterImpl(this)

        signUpButton.setOnClickListener {
            signUpPresenterImpl.validateUserData(UserBean(signUpWidget.getUserName(), signUpWidget.getEmailID(), signUpWidget.getMobileNo()))

        }


    }
}
