package com.android.qualtechassignment.utlities

import com.android.qualtechassignment.listeners.NetworkResponseCallback
import com.android.qualtechassignment.myapplication.MyApplication
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

/**
 * Created by t on 9/23/2017.
 */
class WebServiceUtil {
    companion object {

        private fun getRequest(url: String, listener: NetworkResponseCallback) {
            Logger.d(Logger.COMMON_TAG + "getRequest", url)
            val queue = Volley.newRequestQueue(MyApplication.getInstance()?.applicationContext)
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
            queue.add(stringRequest)

        }

        fun fetchDataFromWebService(url: String, networkResponseCallback: NetworkResponseCallback) {
            getRequest(url, networkResponseCallback)

        }

    }
}