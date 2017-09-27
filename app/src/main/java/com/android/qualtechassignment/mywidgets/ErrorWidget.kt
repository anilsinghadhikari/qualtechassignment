package com.android.watchoveryou.customwidgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.android.qualtechassignment.R
import kotlinx.android.synthetic.main.error_widget_layout.view.*

/**
 * Created by qainfotech on 11/8/17.
 */

class ErrorWidget : LinearLayout {
    private var mContext: Context? = null
    private var attrs: AttributeSet? = null


    public constructor(context: Context) : super(context) {}

    public constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        this.attrs = attrs
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        init()
    }

    private fun init() {
        val inflater = mContext?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.error_widget_layout, this, true)


    }

    public fun show(msg: String) {
        show()
        setErrorMSg(msg)
    }

    public fun show() {
        woyErrortoplayout.visibility = View.VISIBLE
    }

    public fun hide() {
        woyErrortoplayout.visibility = View.GONE
    }

    public fun setErrorMSg(msg: String) {
        errorMsgTextView.setText(msg)
    }


}