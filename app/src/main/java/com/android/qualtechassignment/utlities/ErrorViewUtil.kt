package com.android.watchoveryou.utility

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.widget.Toast
import com.android.qualtechassignment.R
import com.android.qualtechassignment.utlities.ErrorMsg

/**
 * Created by qainfotech on 12/4/16.
 */
object ErrorViewUtil {

    private var alertDialog: AlertDialog? = null
    private var context: Context? = null

    /**
     *
     * @param context
     * @param title
     * @param message
     * @param onClickListener
     */

    @JvmOverloads
    fun showErrorDialog(context: Activity, message: String) {
        showErrorDialog(context, "", message, null)
    }

    @JvmOverloads
    fun showErrorDialog(context: Activity, title: String, message: String, onClickListener: DialogInterface.OnClickListener? = null) {
        var onClickListener = onClickListener
        ErrorViewUtil.context = context
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setTitle(title).setMessage(message)

        if (onClickListener == null) {
            onClickListener = DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() }
        }
        alertDialogBuilder.setPositiveButton("OKAY", onClickListener)

        alertDialog = alertDialogBuilder.create()
        showDialog(false)
    }

    @JvmOverloads
    fun showErrorDialogWithCancelButton(context: Activity, title: String, message: String, onClickListener: DialogInterface.OnClickListener? = null) {
        var onClickListener = onClickListener
        ErrorViewUtil.context = context
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setTitle(title).setMessage(message)

        if (onClickListener == null) {
            onClickListener = DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() }
        }
        alertDialogBuilder.setPositiveButton("OKAY", onClickListener)
        alertDialogBuilder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
            dialogInterface.dismiss()
        })
        alertDialog = alertDialogBuilder.create()
        showDialog(false)
    }


    /**
     * private method to show the dialog and change it's button text color to app theme color
     * @param hasNegativeBtn
     */
    private fun showDialog(hasNegativeBtn: Boolean) {
        alertDialog!!.show()
        alertDialog!!.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(context!!, R.color.colorPrimary))
        if (hasNegativeBtn)
            alertDialog!!.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(context!!, R.color.colorPrimary))
    }

    fun showToast(mActivity: Activity, message: String) {
        Toast.makeText(mActivity, message, Toast.LENGTH_SHORT).show()

    }

    fun showToast(mContext: Context, message: String) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()

    }

    fun noInternetErroDialog(mContext: Activity) {
        showErrorDialog(mContext, ErrorMsg.NO_Internet_TITLE, ErrorMsg.NO_Internet_MSG)
    }

    fun genericErrorView(mActivity: Activity) {
        showErrorDialog(mActivity, ErrorMsg.UNKNOWN_ERROR, ErrorMsg.REQUST_CUDNT_PROCESS)
    }

    fun showInternetNotAvailableDialog(context: Context) {
        showErrorDialog(context as Activity, ErrorMsg.NO_Internet_TITLE, ErrorMsg.NO_Internet_MSG)

    }

}
/**
 *
 * @param context
 * @param title
 * @param message
 */
