package com.android.watchoveryou.adapters

import android.app.Activity
import android.support.v7.widget.ButtonBarLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.android.qualtechassignment.R
import com.android.qualtechassignment.responses.CountryResponse
import com.android.qualtechassignment.utilities.NavigationUtil
import com.google.gson.Gson
import java.util.*
import kotlinx.android.synthetic.main.country_adpater_item_layout.view.*

/**
 * Created by qainfotech on 18/8/17.
 */

class CountryListAdapter(private val mContext: Activity, var countryList: ArrayList<CountryResponse>?) : RecyclerView.Adapter<CountryListAdapter.CountryItemViewHolder>() {
    override fun getItemCount(): Int {

        return countryList?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CountryItemViewHolder {

        val itemLayoutView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.country_adpater_item_layout, null)
        val viewHolder = CountryItemViewHolder(itemLayoutView)

        return viewHolder
    }

    override fun onBindViewHolder(viewHolder: CountryItemViewHolder?, position: Int) {
        val countryResponse = countryList!![position]

        viewHolder?.bindCountryName(countryResponse.name!!)
        viewHolder?.bindCountryCode("Region: " + countryResponse.region.toString()!! + " Subregion: " + countryResponse.subregion.toString()!!)

        viewHolder?.itemLayoutView?.setOnClickListener {
            val gson = Gson()
            NavigationUtil.openCountryDetailActivity(mContext, gson.toJson(countryResponse))

        }

        viewHolder?.getDeleteButton()?.setOnClickListener {
            countryList?.removeAt(position)
            if (position != null) {
                notifyItemRemoved(position)
            }

        }
    }


    // inner class to hold a reference to each item of RecyclerView
    inner class CountryItemViewHolder(val itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {

        fun bindCountryName(countryName: String) {
            itemLayoutView.countryName.text = countryName
        }

        fun bindCountryCode(countryCode: String) {
            itemLayoutView.countryCode.text = countryCode
        }

        fun getDeleteButton(): ImageButton? {
            return itemLayoutView.deleteImageBtn
        }


    }


}