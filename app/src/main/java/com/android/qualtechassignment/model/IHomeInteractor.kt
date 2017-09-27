package com.android.qualtechassignment.model

import com.android.qualtechassignment.responses.CountryResponse

/**
 * Created by t on 9/23/2017.
 */
interface IHomeInteractor {

    interface OnCountryDataFetchedListener {
        fun onFailure(msg: String = "Unknown error")

        fun onSuccess(list: ArrayList<CountryResponse>)
    }

    fun fetchCountry(listener: OnCountryDataFetchedListener)
}