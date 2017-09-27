package com.android.watchoveryou.customwidgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.android.qualtechassignment.R
import kotlinx.android.synthetic.main.progress_bar_layout.view.*

/**
 * Created by qainfotech on 11/8/17.
 */

class WOYProgressBarWidget : LinearLayout {
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
        inflater.inflate(R.layout.progress_bar_layout, this, true)


    }

    public fun show(msg: String) {
        show()
        setProgressMsg(msg)
    }

    public fun show() {
        progressMsgTextView.visibility = View.VISIBLE
        woyProgressBar.visibility = View.VISIBLE
    }

    public fun hide() {
        progressMsgTextView.visibility = View.GONE
        woyProgressBar.visibility = View.GONE

    }

    public fun setProgressMsg(msg: String) {
        progressMsgTextView.setText(msg)
    }


}