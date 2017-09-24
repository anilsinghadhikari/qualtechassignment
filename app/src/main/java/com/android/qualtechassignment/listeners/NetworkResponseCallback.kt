package com.android.qualtechassignment.listeners

/**
 * Created by QAIT\trilokinathyadav on 9/8/16.
 */
interface NetworkResponseCallback {

    /**
     * On success.
     *
     * @param response the response
     */
    fun onSuccess(response: String)

    /**
     * On error.
     *
     * @param error the error
     */
    fun onError(error: String)

    /**
     * On invalid response.
     *
     * @param error the error
     */
    //    void  onInvalidResponse(Error error);
}
