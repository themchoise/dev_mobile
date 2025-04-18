package com.example.mjoyce.tp1.ej2_conversor

import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mjoyce.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.text.TextWatcher
import android.text.Editable
import android.view.View
import android.widget.Spinner

class ConversorView : AppCompatActivity() {

    private lateinit var currency: CurrencyResponse


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

        val spinner: Spinner = findViewById(R.id.spnLoad)
        CoroutineScope(Dispatchers.Main).launch {
            val apiStart = ApiCurrency()
            var currSelected: String = ""

            currency = withContext(Dispatchers.IO) {
                apiStart.getCurrencyes()
            }

            val valueToConvert: EditText = findViewById(R.id.editTextText3)
            val valueResult: TextView = findViewById(R.id.textResult)


            val buttons: List<RadioButton> = listOf(
                findViewById(R.id.rbusd),
                findViewById(R.id.rbeur),
                findViewById(R.id.rbbrl),
            )

            buttons.forEach { button ->
                button.setOnClickListener {
                    if (valueToConvert.text.toString().isEmpty()) {
                        val toast = Toast.makeText(
                            this@ConversorView,
                            "Debe ingresar un valor",
                            Toast.LENGTH_SHORT
                        )
                        toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 200)
                        toast.show()

                    } else {

                        val currencySelected: String = button.text.toString()
                        currSelected = currencySelected

                        buttons.filter { it.text.toString() != currencySelected }.forEach {
                            it.isChecked = false
                        }
                        spinner.isEnabled = true
                        spinner.visibility = View.VISIBLE
                        val result = valueToConvert.text.toString()
                            .toFloat() * currency.rates[currencySelected].toString().toFloat()
                        valueResult.text = "$currencySelected: $result"
                    }


                }

            }
            valueToConvert.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (currSelected.isNotEmpty()) {
                        val nuevoValor = s.toString()
                        val result = nuevoValor
                            .toFloat() * currency.rates[currSelected].toString().toFloat()
                        valueResult.text = "$currSelected: $result"
                    }

                }

                override fun afterTextChanged(s: Editable?) {
                }
            })

        }
    }
}