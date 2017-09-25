package com.android.qualtechassignment.model

import android.os.Handler
import com.android.qualtechassignment.data.UserBean
import com.android.qualtechassignment.listeners.NetworkResponseCallback
import com.android.qualtechassignment.responses.CountryResponse
import com.android.qualtechassignment.utlities.WebServiceUtil
import com.android.qualtechassignment.utlities.WebURL
import com.google.gson.Gson

/**
 * Created by t on 9/23/2017.
 */
class HomeInteractorImpl : IHomeInteractor {

    override fun fetchCountry(listener: IHomeInteractor.OnCountryDataFetchedListener) {

        WebServiceUtil.fetchDataFromWebService(WebURL.API_COUNTRIES, object : NetworkResponseCallback {
            override fun onSuccess(response: String) {
                val gson = Gson()
//                val countryResponce = gson.fromJson(response, CountryResponse::class.java)
//                listener.onSuccess(countryResponce)

            }

            override fun onError(error: String) {
                listener.onFailure(error)
            }

        })

    }


}