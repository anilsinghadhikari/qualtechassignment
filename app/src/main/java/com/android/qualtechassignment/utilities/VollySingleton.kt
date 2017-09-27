package com.android.watchoveryou.utility

import android.content.Context
import com.android.qualtechassignment.myapplication.MyApplication
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

/**
 * Created by qainfotech on 21/8/17.
 */

class VollySingleton() {
    private var mRequestQueue: RequestQueue? = null

    init {
        mRequestQueue = getRequestQueue


    }

    // getApplicationContext() is key, it keeps you from leaking the
    // Activity or BroadcastReceiver if someone passes one in.

    val getRequestQueue: RequestQueue
        get() {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(mCtx.applicationContext)
            }
            return mRequestQueue!!
        }

    lateinit var volleyReq: Request<String>

    fun <T> addToRequestQueue(req: Request<String>) {
        volleyReq = req
        getRequestQueue.add(req)
    }

    companion object {
        private var mInstance: VollySingleton? = null
        private var mCtx: Context = MyApplication.getInstance()?.applicationContext!!

        @Synchronized
        fun getInstance(): VollySingleton {
            if (mInstance == null) {
                mInstance = VollySingleton()
            }
            return mInstance!!
        }


    }


}