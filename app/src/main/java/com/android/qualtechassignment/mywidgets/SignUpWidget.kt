package com.android.qualtechassignment.mywidgets

import android.animation.ObjectAnimator
import android.content.Context
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.LinearLayout
import com.android.qualtechassignment.R
import com.android.qualtechassignment.utilities.Utility
import kotlinx.android.synthetic.main.signup_widget_layout.view.*


class SignUpWidget : LinearLayout {
    private var mContext: Context? = null
    private var attrs: AttributeSet? = null
    private var animationDone: Boolean = false

    /* private val nameEditText: EditText by bind(R.id.nameEditText)
     private val emailEditText: EditText by bind(R.id.emailEditText)
     private val phoneEditText: EditText by bind(R.id.phoneEditText)
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
        inflater.inflate(R.layout.signup_widget_layout, this, true)

        nameEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (!TextUtils.isEmpty(s)) {
                    nameEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(mContext, R.drawable.rotate), null)
                    if (!animationDone)
                        animateMe(nameEditText);
                } else {
                    animationDone = false;
                    nameEditText.setCompoundDrawables(null, null, null, null);

                }


            }

        })


        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (Utility.validEmail(s.toString())) {
                    emailEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(mContext, R.drawable.rotate), null)
                    if (!animationDone)
                        animateMe(emailEditText);
                } else {
                    animationDone = false;
                    emailEditText.setCompoundDrawables(null, null, null, null);

                }


            }

        })

        phoneEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (Utility.isValidNo(s.toString())) {
                    phoneEditText.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(mContext, R.drawable.rotate), null)
                    if (!animationDone)
                        animateMe(phoneEditText);
                } else {
                    animationDone = false;
                    phoneEditText.setCompoundDrawables(null, null, null, null);

                }


            }

        })

    }


    private fun animateMe(editText: EditText) {
        animationDone = true
        val MAX_LEVEL = 10000

        val myTextViewCompoundDrawables = editText.compoundDrawables
        for (drawable in myTextViewCompoundDrawables) {

            if (drawable == null)
                continue

            val anim = ObjectAnimator.ofInt(drawable, "level", 0, MAX_LEVEL)
            anim.start()
        }
    }

    public fun getUserName(): String {
        return nameEditText.text.toString()
    }

    public fun getEmailID(): String {
        return emailEditText.text.toString()
    }

    public fun getMobileNo(): String {
        return phoneEditText.text.toString()
    }


}