package com.example.mjoyce.tp0

import android.annotation.SuppressLint
import android.widget.Button;
import android.content.Context;
import android.graphics.Color
import android.widget.EditText

class Ejercicio(private val context: Context) {

    fun invertirTexto(btn: Button, text:EditText, textResult: EditText) {

        btn.setOnClickListener {

            textResult.setText(text.text.toString().reversed())

        }
    }

    @SuppressLint("SetTextI18n")
    fun qntCaracteres(btn: Button, text:EditText, textResult: EditText){
        btn.setOnClickListener {

            val longitud = text.text.toString().length
            textResult.setText("Longitud: $longitud")

        }
    }

    @SuppressLint("SetTextI18n")
    fun cambioColor(btn: Button, text:EditText){
        btn.setOnClickListener {

            text.setTextColor(Color.RED)

        }
    }

}
