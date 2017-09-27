package com.android.qualtechassignment.utilities

import android.content.Context
import android.net.ConnectivityManager
import com.android.qualtechassignment.listeners.NetworkResponseCallback
import com.android.qualtechassignment.myapplication.MyApplication
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.android.watchoveryou.utility.VollySingleton

/**
 * Created by t on 9/23/2017.
 */
class WebServiceUtil {
    companion object {

        private fun getRequest(url: String, listener: NetworkResponseCallback) {
            Logger.d(Logger.COMMON_TAG + "getRequest", url)
            val stringRequest = StringRequest(Request.Method.GET, url,
                    object : Response.Listener<String> {
                        override fun onResponse(response: String) {
                            listener.onSuccess(response)
                            Logger.d(Logger.COMMON_TAG, response)

                        }
                    }, object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError) {

                    listener.onError(ErrorMsg.UNKNOWN_ERROR)
                    if (error != null)
                        Logger.d(error.localizedMessage)
                }
            })

            VollySingleton.getInstance().addToRequestQueue<StringRequest>(stringRequest)

        }

        fun fetchDataFromWebService(url: String, networkResponseCallback: NetworkResponseCallback) {
            getRequest(url, networkResponseCallback)

        }

        fun isInternetAvailable(): Boolean {
            val manager = MyApplication.getInstance()?.applicationContext?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = manager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable && activeNetworkInfo.isConnected
        }

    }
}