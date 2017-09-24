package com.android.qualtechassignment.model

import com.android.qualtechassignment.data.UserBean

/**
 * Created by t on 9/23/2017.
 */
interface ISignUpInteractor {

    interface OnSignUpFinishedListener {
        fun onFailure(msg: String="Unknown error")

        fun onSuccess()
    }

    fun signUp(userBean: UserBean, listener: OnSignUpFinishedListener)
}