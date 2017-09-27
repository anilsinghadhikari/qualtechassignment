package com.android.qualtechassignment.presenters

import android.view.View
import com.android.qualtechassignment.model.HomeInteractorImpl
import com.android.qualtechassignment.model.IHomeInteractor
import com.android.qualtechassignment.responses.CountryResponse
import com.android.qualtechassignment.utilities.ErrorMsg
import com.android.qualtechassignment.utilities.WebServiceUtil
import com.android.qualtechassignment.views.HomeView
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by t on 9/23/2017.
 */
class HomePresenterImpl(var homeView: HomeView) : IHomePresenter, IHomeInteractor.OnCountryDataFetchedListener {

    override fun fetchCountryData() {

        if (WebServiceUtil.isInternetAvailable()) {
            val homeInteractorImpl = HomeInteractorImpl()
            homeView.showProgress()
            homeInteractorImpl.fetchCountry(this)
        } else {
            homeView.showErrorMsg(ErrorMsg.NO_Internet_MSG)
        }


    }

    override fun onFailure(msg: String) {
        homeView.showErrorMsg(msg)
    }

    override fun onSuccess(list: ArrayList<CountryResponse>) {
        homeView.hideProgress()
        homeView.showCountryToUI(list)
    }


}