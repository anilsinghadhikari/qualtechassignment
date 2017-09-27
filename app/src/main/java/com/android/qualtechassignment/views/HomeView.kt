package com.android.qualtechassignment.views

import com.android.qualtechassignment.responses.CountryResponse

/**
 * Created by t on 9/23/2017.
 */
interface HomeView {

    fun showProgress()
    fun hideProgress()
    fun showErrorMsg(errorMsg: String)
    fun showCountryToUI(list: ArrayList<CountryResponse>)

}