package com.android.qualtechassignment

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.android.qualtechassignment.presenters.HomePresenterImpl
import com.android.qualtechassignment.responses.CountryResponse
import com.android.qualtechassignment.utlities.Utility
import com.android.qualtechassignment.utlities.bind
import com.android.qualtechassignment.views.HomeView
import com.android.watchoveryou.adapters.GeneralNotificationListAdapter

class HomeActivity : BaseActivity(), HomeView {

    override fun setContent() {
        setContentView(R.layout.activity_home)
    }

    private val countryRecyclerView by bind<RecyclerView>(R.id.countryrecyclerView)

    override fun showCountryToUI(countryResponse: CountryResponse) {
//        countryRecyclerView?.adapter = GeneralNotificationListAdapter(this, countryResponse)
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showErrorMsg(errorMsg: String) {

    }


    override fun getToolBarTitle(): String {
        return Utility.getStringFromResource(R.string.title_home)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val homePresenterImpl = HomePresenterImpl(this)
        homePresenterImpl.fetchCountryData()


    }
}
