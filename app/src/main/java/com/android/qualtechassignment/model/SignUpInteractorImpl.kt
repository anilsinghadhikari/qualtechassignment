package com.android.qualtechassignment.model

import android.os.Handler
import com.android.qualtechassignment.data.UserBean

/**
 * Created by t on 9/23/2017.
 */
class SignUpInteractorImpl : ISignUpInteractor {
    override fun signUp(userBean: UserBean, listener: ISignUpInteractor.OnSignUpFinishedListener) {

        Handler().postDelayed(Runnable {
            listener.onSuccess()
        }, 3000)
    }

}