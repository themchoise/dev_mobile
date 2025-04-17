package com.example.mjoyce.tp1

import android.widget.TextView
import java.math.BigInteger

interface CalculadoraInterface {

    fun sumar()

    fun restar()
    fun dividir()
    fun multiplicar()
    fun procesar(textShowResult: TextView, textScreenTextButtonsPushed: TextView)
    fun limpiar()


}
