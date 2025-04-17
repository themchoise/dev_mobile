package com.example.mjoyce.tp1.ej1_calculadora

import android.widget.TextView

interface CalculadoraInterface {

    fun sumar()

    fun restar()
    fun dividir()
    fun multiplicar()
    fun procesar(textShowResult: TextView, textScreenTextButtonsPushed: TextView)
    fun limpiar()


}
