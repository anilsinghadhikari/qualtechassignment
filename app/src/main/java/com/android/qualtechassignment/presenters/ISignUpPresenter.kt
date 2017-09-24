package com.android.qualtechassignment.presenters

import com.android.qualtechassignment.data.UserBean

/**
 * Created by t on 9/23/2017.
 */
interface ISignUpPresenter : IBasePresenter {

    fun validateUserData(userDataClass: UserBean)


}