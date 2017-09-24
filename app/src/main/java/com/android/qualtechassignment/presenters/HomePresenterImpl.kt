package com.android.qualtechassignment.presenters

import com.android.qualtechassignment.model.HomeInteractorImpl
import com.android.qualtechassignment.model.IHomeInteractor
import com.android.qualtechassignment.responses.CountryResponse
import com.android.qualtechassignment.views.HomeView

/**
 * Created by t on 9/23/2017.
 */
class HomePresenterImpl(var homeView: HomeView) : IHomePresenter, IHomeInteractor.OnCountryDataFetchedListener {

    override fun fetchCountryData() {

        val homeInteractorImpl = HomeInteractorImpl()
        homeInteractorImpl.fetchCountry(this)

    }

    override fun onFailure(msg: String) {

    }

    override fun onSuccess(countryResponse: CountryResponse) {
        homeView.showCountryToUI(countryResponse)
    }


}