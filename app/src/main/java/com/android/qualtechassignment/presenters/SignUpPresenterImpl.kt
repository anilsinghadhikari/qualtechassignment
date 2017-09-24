package com.android.qualtechassignment.presenters

import android.text.TextUtils
import com.android.qualtechassignment.R
import com.android.qualtechassignment.SignUpActivity
import com.android.qualtechassignment.data.UserBean
import com.android.qualtechassignment.model.ISignUpInteractor
import com.android.qualtechassignment.model.SignUpInteractorImpl
import com.android.qualtechassignment.utlities.Utility
import com.android.qualtechassignment.views.SignUpView

/**
 * Created by t on 9/23/2017.
 */
class SignUpPresenterImpl(var signUpView: SignUpView) : ISignUpPresenter, ISignUpInteractor.OnSignUpFinishedListener {


    var iSignUpInteractor: ISignUpInteractor? = null
    override fun onFailure(msg: String) {
        signUpView.hideProgress()
        signUpView.showErrorMsg(msg)
    }

    override fun onSuccess() {
        signUpView.hideProgress()
    }

    override fun validateUserData(userDataClass: UserBean) {
        if (TextUtils.isEmpty(userDataClass.userName)) {
            signUpView.showErrorMsg(Utility.getStringFromResource(R.string.validation_username))
            return
        }
        if (TextUtils.isEmpty(userDataClass.email)) {
            signUpView.showErrorMsg(Utility.getStringFromResource(R.string.validation_email))
            return
        }
        if (TextUtils.isEmpty(userDataClass.phoneNo)) {
            signUpView.showErrorMsg(Utility.getStringFromResource(R.string.validation_mobileno))
            return
        }

        iSignUpInteractor = SignUpInteractorImpl()
        iSignUpInteractor?.signUp(userDataClass, this)
    }

}