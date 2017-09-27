package com.android.qualtechassignment.model

import com.android.qualtechassignment.listeners.NetworkResponseCallback
import com.android.qualtechassignment.responses.CountryResponse
import com.android.qualtechassignment.utilities.WebServiceUtil
import com.android.qualtechassignment.utilities.WebURL
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by t on 9/23/2017.
 */
class HomeInteractorImpl : IHomeInteractor {

    override fun fetchCountry(listener: IHomeInteractor.OnCountryDataFetchedListener) {

        WebServiceUtil.fetchDataFromWebService(WebURL.API_COUNTRIES, object : NetworkResponseCallback {
            override fun onSuccess(response: String) {
                val gson = Gson()
                val turnsType = object : TypeToken<List<CountryResponse>>() {}.type
                val countryList = gson.fromJson<ArrayList<CountryResponse>>(response, turnsType)

                listener.onSuccess(countryList)

            }

            override fun onError(error: String) {
                listener.onFailure(error)
            }

        })

    }


}