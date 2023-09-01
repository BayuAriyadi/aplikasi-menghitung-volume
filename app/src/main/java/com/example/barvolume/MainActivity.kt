package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWidth: EditText
    private lateinit var edtLength: EditText
    private lateinit var edtTall: EditText
    private lateinit var btnHitung: Button
    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtWidth = findViewById(R.id.edt_width)
        edtLength = findViewById(R.id.edt_length)
        edtTall = findViewById(R.id.edt_tall)
        btnHitung = findViewById(R.id.btn_hitung)
        tvResult = findViewById(R.id.tv_result)
        btnHitung.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_hitung) {
            var isEmptyFields = false
            val inputLength = edtLength.text.toString().trim()
            if (inputLength.isEmpty()) {
                isEmptyFields = true
                edtLength.error = "field ini tidak boleh kosong bro"
            }
            val inputWidth = edtWidth.text.toString().trim()
            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                edtWidth.error = "field ini tidak boleh kosong bro"
            }
            val inputTall = edtTall.text.toString().trim()
            if (inputTall.isEmpty()) {
                isEmptyFields = true
                edtTall.error = "field ini tidak boleh kosong bro"
            }

            if (!isEmptyFields) {
                val volume = inputWidth.toDouble()*inputLength.toDouble()*inputTall.toDouble()
                tvResult.text = volume.toString()
            }
        }
    }
}