package com.example.mjoyce.tp1.ej2_conversor

import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mjoyce.R
import com.example.mjoyce.tp1.ej1_calculadora.Calculadora
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ConversorView : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_conversor)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.conversor)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val apiStart = ApiCurrency()
        var currency
        CoroutineScope(Dispatchers.Main).launch {
            currency = withContext(Dispatchers.IO) {
                apiStart.getCurrencyes()
            }
        }


        val btnUSD: Button = findViewById(R.id.rbusd)
        val btnEUR: Button = findViewById(R.id.rbeur)
        val btnBRL: Button = findViewById(R.id.rbbrl)


    }
}