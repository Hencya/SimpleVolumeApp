package com.example.volumepersegipanjang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWdith : EditText
    private lateinit var edtHeigth :EditText
    private lateinit var edtLength : EditText
    private lateinit var btnCalculate : Button
    private lateinit var tvResult : TextView

    companion object {
        private val STATE_RESULT = "state result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,tvResult.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtLength = findViewById(R.id.edt_length)
        edtHeigth = findViewById(R.id.edt_heigth)
        edtWdith = findViewById(R.id.edt_width)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if(savedInstanceState != null){
            val result =savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }

    override fun onClick(v: View?) {
        if(v?.id == R.id.btn_calculate){
            val inputLegth =edtLength.text.toString().trim()
            val inputWidth = edtWdith.text.toString().trim()
            val inputHeight = edtHeigth.text.toString().trim()

            var isEmptyField = false

            when {
                inputLegth.isEmpty()-> {
                    isEmptyField = true
                    edtLength.error = "This Field Must Be Field in"
                }

                inputHeight.isEmpty()->{
                    isEmptyField = true
                    edtHeigth.error = "This Field Must Be Field in"
                }

                inputWidth.isEmpty()->{
                    isEmptyField=true
                    edtWdith.error = "This Field Must Be Field in"
                }
            }
            if (!isEmptyField) {
                val volume = inputHeight.toDouble() * inputLegth.toDouble() * inputWidth.toDouble()
                tvResult.text = volume.toString()
            }
        }
    }//onClick
}//mainActivity





