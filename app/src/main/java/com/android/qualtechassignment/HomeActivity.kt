package com.android.qualtechassignment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.android.qualtechassignment.presenters.HomePresenterImpl
import com.android.qualtechassignment.responses.CountryResponse
import com.android.qualtechassignment.utilities.ErrorMsg
import com.android.qualtechassignment.utilities.NavigationUtil
import com.android.qualtechassignment.utilities.Utility
import com.android.qualtechassignment.utilities.bind
import com.android.qualtechassignment.views.HomeView
import com.android.watchoveryou.adapters.CountryListAdapter
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : BaseActivity(), HomeView {

    override fun setContent() {
        setContentView(R.layout.activity_home)
    }

    private val countryRecyclerView by bind<RecyclerView>(R.id.countryrecyclerView)

    override fun showCountryToUI(list: ArrayList<CountryResponse>) {

        val linearLayoutManager = LinearLayoutManager(this@HomeActivity)
        countryRecyclerView?.layoutManager = linearLayoutManager
        countryRecyclerView?.adapter = CountryListAdapter(this, list)

    }

    override fun showProgress() {
        progressBarWidget.show("Fetching country list...")
        countryRecyclerView?.visibility = View.GONE
        errorWidgetHome.hide()
    }

    override fun hideProgress() {
        progressBarWidget.hide()
        errorWidgetHome.hide()
        countryRecyclerView?.visibility = View.VISIBLE
    }

    override fun showErrorMsg(errorMsg: String) {
        countryRecyclerView?.visibility = View.GONE
        errorWidgetHome.show(ErrorMsg.NO_Internet_MSG)
        progressBarWidget.hide()
    }


    override fun getToolBarTitle(): String {
        return Utility.getStringFromResource(R.string.title_home)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val homePresenterImpl = HomePresenterImpl(this)
        homePresenterImpl.fetchCountryData()

    }

    private var menuMain: Menu? = null

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuMain = menu!!
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.getItemId() == R.id.action_profile) {
            NavigationUtil.openProfileActivity(this)

        }
        return super.onOptionsItemSelected(item)
    }


}
