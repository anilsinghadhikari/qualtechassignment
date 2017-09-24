package com.android.qualtechassignment.mywidgets

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.android.qualtechassignment.R
import kotlinx.android.synthetic.main.custom_button_layout.view.*


class CustomSubmitButton : FrameLayout {
    private var mContext: Context? = null
    private var attrs: AttributeSet? = null

    /* private val progressContainerLayout: LinearLayout by bind(R.id.progressContainerLayout)
     private val progressBar: LinearLayout by bind(R.id.progressBar)
     private val messageTextView: TextView by bind(R.id.messageTextView)
     private val submitButton: Button by bind(R.id.submitButton)
 */
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


        topClickableLayout.setOnClickListener {
//            Erro

        }

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