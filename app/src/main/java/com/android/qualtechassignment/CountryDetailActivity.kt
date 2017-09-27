package com.android.qualtechassignment

import android.os.Bundle
import android.text.TextUtils
import com.android.qualtechassignment.responses.CountryResponse
import com.android.qualtechassignment.utilities.Constant
import com.android.qualtechassignment.utilities.Utility
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_country_detail.*

class CountryDetailActivity : BaseActivity() {
    override fun setContent() {
        setContentView(R.layout.activity_country_detail)

    }

    override fun getToolBarTitle(): String {

        return Utility.getStringFromResource(R.string.title_country_detail)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if (intent != null && intent?.hasExtra(Constant.KEY_COUNTRY)!!) {
            var countryResponseString = intent.getSerializableExtra(Constant.KEY_COUNTRY) as String
            if (!TextUtils.isEmpty(countryResponseString)) {
                val countrResponceObject = Gson().fromJson(countryResponseString, CountryResponse::class.java)
                setDataToUI(countrResponceObject)
            }
        }


    }

    private fun setDataToUI(countrResponceObject: CountryResponse?) {

        detailTextView.setText("name: " + countrResponceObject?.name + " \n" + " region: " + countrResponceObject?.region + " subregion: " +
                countrResponceObject?.subregion + " currencies: " + countrResponceObject?.currencies)

    }
}
