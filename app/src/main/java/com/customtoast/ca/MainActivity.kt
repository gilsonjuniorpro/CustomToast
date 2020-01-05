package com.customtoast.ca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btShowDefaultToast.setOnClickListener {
            showToast(Constants.DEFAULT)
        }
        btShowSuccessToast.setOnClickListener {
            showToast(Constants.SUCCESS)
        }
        btShowErrorToast.setOnClickListener {
            showToast(Constants.ERROR)
        }
    }

    private fun showToast(type: Int) {
        val toastView = layoutInflater.inflate(
            R.layout.toast_layout,
            findViewById(R.id.toast_body)
        )

        val toastBody = toastView.findViewById<LinearLayout>(R.id.toast_body)
        val toastIcon = toastView.findViewById<ImageView>(R.id.toast_icon)
        val toastMessage = toastView.findViewById<TextView>(R.id.toast_message)

        when (type) {
            Constants.DEFAULT -> {
                toastBody.setBackgroundResource(R.drawable.toast_default_background)
                toastIcon.setImageResource(R.drawable.ic_default)
                toastMessage.setText(R.string.default_toast_message)
            }

            Constants.SUCCESS -> {
                toastBody.setBackgroundResource(R.drawable.toast_success_background)
                toastIcon.setImageResource(R.drawable.ic_success)
                toastMessage.setText(R.string.success_toast_message)
            }

            Constants.ERROR -> {
                toastBody.setBackgroundResource(R.drawable.toast_error_background)
                toastIcon.setImageResource(R.drawable.ic_error)
                toastMessage.setText(R.string.error_toast_message)
            }
        }

        with(Toast(applicationContext)) {
            duration = Toast.LENGTH_LONG
            view = toastView
            show()
        }
    }

}