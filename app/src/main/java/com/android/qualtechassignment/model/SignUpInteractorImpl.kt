package com.android.qualtechassignment.model

import android.os.Handler
import com.android.qualtechassignment.data.UserBean
import com.android.qualtechassignment.database.SqliteDbHelper

/**
 * Created by t on 9/23/2017.
 */
class SignUpInteractorImpl : ISignUpInteractor {
    override fun signUp(userBean: UserBean, listener: ISignUpInteractor.OnSignUpFinishedListener) {

        Handler().postDelayed(Runnable {
            listener.onSuccess()
            SqliteDbHelper.getInstance()?.saveUserData(userBean)

        }, 1500)
    }

}