package com.android.qualtechassignment.presenters

import android.text.TextUtils
import com.android.qualtechassignment.R
import com.android.qualtechassignment.data.UserBean
import com.android.qualtechassignment.model.ISignUpInteractor
import com.android.qualtechassignment.model.SignUpInteractorImpl
import com.android.qualtechassignment.utilities.Utility
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
        signUpView.navigateToHomeActivity()


    }

    override fun validateUserData(userDataClass: UserBean) {
        if (TextUtils.isEmpty(userDataClass.userName)) {
            signUpView.showErrorMsg(Utility.getStringFromResource(R.string.validation_username))
            return
        }
        if (!Utility.validEmail(userDataClass.email)) {
            signUpView.showErrorMsg(Utility.getStringFromResource(R.string.validation_email_required))
            return
        }

        if (!Utility.isValidNo(userDataClass.mobileNo)) {
            signUpView.showErrorMsg(Utility.getStringFromResource(R.string.validation_mobileno_10_digit))
            return
        }


        iSignUpInteractor = SignUpInteractorImpl()
        signUpView.showProgress()
        iSignUpInteractor?.signUp(userDataClass, this)
    }

}