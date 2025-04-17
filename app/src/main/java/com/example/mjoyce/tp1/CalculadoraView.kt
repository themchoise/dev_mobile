package com.example.mjoyce.tp1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mjoyce.R
import com.example.mjoyce.tp0.Ejercicio

class CalculadoraView : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.calculadora_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.calculadora)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val calc = Calculadora()

        val buttons: List<Button> = listOf(
            findViewById(R.id.btn0),
            findViewById(R.id.btn1),
            findViewById(R.id.btn2),
            findViewById(R.id.btn3),
            findViewById(R.id.btn4),
            findViewById(R.id.btn5),
            findViewById(R.id.btn6),
            findViewById(R.id.btn7),
            findViewById(R.id.btn8),
            findViewById(R.id.btn9)
        )
        val btnSuma: Button = findViewById(R.id.btnSum)
        val btnResta: Button = findViewById(R.id.btnResta)
        val btnDiv: Button = findViewById(R.id.btnDiv)
        val btnMult: Button = findViewById(R.id.btnMult)
        val btnResult: Button = findViewById(R.id.btnResult)
        val btnClean: Button = findViewById(R.id.btnClear)
        val textShowResult: TextView = findViewById(R.id.resultText)
        val textScreenTextButtonsPushed: TextView = findViewById(R.id.screenTextButtonsPushed)

        buttons.forEach { button ->
            button.setOnClickListener {
                textScreenTextButtonsPushed.text =
                    textScreenTextButtonsPushed.text.toString() + " " + button.text.toString() + " "
                if (calc.operation == Operaciones.STANDBY) {
                    calc.firstValue = (calc.firstValue.toString() + button.text.toString()).toLong()
                } else {
                    println("R")
                    calc.secondValue =
                        (calc.secondValue.toString() + button.text.toString()).toLong()
                }
            }
        }
        btnSuma.setOnClickListener {

            textScreenTextButtonsPushed.text =
                textScreenTextButtonsPushed.text.toString() + " " + btnSuma.text.toString() + " "
            calc.operation = Operaciones.SUM
        }
        btnResta.setOnClickListener {

            textScreenTextButtonsPushed.text =
                textScreenTextButtonsPushed.text.toString() + " " + btnResta.text.toString() + " "
            calc.operation = Operaciones.RES
        }
        btnResult.setOnClickListener {
            calc.procesar(textShowResult, textScreenTextButtonsPushed)
        }

        btnClean.setOnClickListener {
            textScreenTextButtonsPushed.text = ""
            textShowResult.text = "0"
            calc.limpiar()
            println("Hola")
        }
        btnDiv.setOnClickListener {
          
            textScreenTextButtonsPushed.text =
                textScreenTextButtonsPushed.text.toString() + " " + btnDiv.text.toString() + " "
            calc.operation = Operaciones.DIV
        }


        btnMult.setOnClickListener {

            textScreenTextButtonsPushed.text =
                textScreenTextButtonsPushed.text.toString() + " " + btnMult.text.toString() + " "
            calc.operation = Operaciones.MULT
        }


    }
}
