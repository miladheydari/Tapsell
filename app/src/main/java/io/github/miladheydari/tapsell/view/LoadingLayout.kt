package io.github.miladheydari.tapsell.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import io.github.miladheydari.tapsell.R


class LoadingLayout : RelativeLayout {
    private var mContext: Context? = null
    private var vError: View? = null
    private var mainLayout: View? = null
    private var vLoading: View? = null

    private var listener: View.OnClickListener? = null
    var state = 2
        set(mState) {
            field = mState

            when (mState) {
                STATE_LOADING -> {
                    vError!!.visibility = View.GONE
                    mainLayout!!.visibility = View.INVISIBLE
                    vLoading!!.visibility = View.VISIBLE
                }
                STATE_SHOW_DATA -> {
                    vLoading!!.visibility = View.GONE
                    vError!!.visibility = View.GONE


                    mainLayout!!.visibility = View.VISIBLE

                }
                STATE_SHOW_ERROR -> {
                    mainLayout!!.visibility = View.INVISIBLE
                    vLoading!!.visibility = View.GONE
                    vError!!.visibility = View.VISIBLE

                }
            }

        }

    fun setListener(listener: View.OnClickListener) {
        this.listener = listener
    }


    constructor(context: Context) : super(context) {
        initializeViews(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initializeViews(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        initializeViews(context)
    }


    private fun initializeViews(context: Context) {
        this.mContext = context


    }


    override fun onFinishInflate() {
        super.onFinishInflate()

        val inflater = LayoutInflater.from(mContext)
        vError = inflater.inflate(R.layout.layout_error, null)
        vLoading = inflater.inflate(R.layout.layout_loading, null)
        vError!!.setOnClickListener { v ->
            if (listener != null) {
                state = STATE_LOADING
                listener!!.onClick(v)
            }
        }


        val lp = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)


        lp.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE)



        vError?.layoutParams = lp
        vLoading?.layoutParams = lp


        mainLayout = getChildAt(0)

        addView(vLoading)
        addView(vError)

        state = STATE_LOADING

    }


    fun setError(mError: String) {
        val tvError = vError!!.findViewById<TextView>(R.id.lbl_error)
        tvError.text = mError
        state = STATE_SHOW_ERROR
    }

    companion object {

        const val STATE_LOADING = 1
        const val STATE_SHOW_DATA = 2
        const val STATE_SHOW_ERROR = 3
    }

}