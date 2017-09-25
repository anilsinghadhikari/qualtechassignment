package com.android.qualtechassignment.mywidgets

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.android.qualtechassignment.R
import com.android.qualtechassignment.utlities.Logger
import kotlinx.android.synthetic.main.custom_button_layout.view.*


class CustomSubmitButton : FrameLayout {
    private var mContext: Context? = null
    private var attrs: AttributeSet? = null
    private lateinit var onCustomClickListener: OnCustomClickLister

    init {
        this.mContext = context
        this.attrs = attrs
    }

    public constructor(context: Context) : super(context) {}

    public constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        this.attrs = attrs
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        val inflater = mContext?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.custom_button_layout, this, true)

        submitButton.setOnClickListener {
            Logger.d("inside CustomSubmitButton click")
            topClickableLayout.performClick()
            if (onCustomClickListener != null) {
                onCustomClickListener.onButtonClick()
            }
        }


    }

    public fun setCustomClickListener(onCustomClickListener: OnCustomClickLister) {
        this.onCustomClickListener = onCustomClickListener

    }

    interface OnCustomClickLister {
        fun onButtonClick()

    }

    fun showProgress(msg: String = "") {
        progressBar.visibility = View.VISIBLE
        submitButton.visibility = View.GONE
        if (TextUtils.isEmpty(msg)) {
            messageTextView.visibility = View.GONE
        } else {
            messageTextView.visibility = View.VISIBLE
            messageTextView.text = msg
        }
    }

    fun hideProgress() {
        progressBar.visibility = View.GONE
        messageTextView.visibility = View.GONE
        submitButton.visibility = View.VISIBLE

    }

}