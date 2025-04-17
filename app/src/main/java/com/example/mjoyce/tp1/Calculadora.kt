package com.example.mjoyce.tp1

import android.widget.TextView
import java.math.BigInteger

class Calculadora : CalculadoraInterface {

    var firstValue: Long = 0L
    var secondValue: Long = 0L
    var result: Float = 0F
    var operation: Operaciones = Operaciones.STANDBY


    override fun sumar() {

        this.result = (this.firstValue + this.secondValue).toFloat()
    }

    override fun restar() {
        this.result = (this.firstValue - this.secondValue).toFloat()
    }

    override fun dividir() {
        if (this.secondValue != 0L) {
            this.result = (this.firstValue / this.secondValue).toFloat()
        } else {
            this.result = 0F
        }

    }

    override fun multiplicar() {
        this.result = (this.firstValue * this.secondValue).toFloat()

    }

    override fun procesar(textShowResult: TextView, textScreenTextButtonsPushed: TextView) {
        when (this.operation) {
            Operaciones.SUM -> this.sumar()
            Operaciones.RES -> this.restar()
            Operaciones.DIV -> this.dividir()
            Operaciones.MULT -> this.multiplicar()
            else -> println("")
        }
        println(this.operation)

        this.secondValue = 0L


        this.firstValue = this.result.toLong()
        textShowResult.text = this.result.toString()
        textScreenTextButtonsPushed.text = this.result.toString()
        //this.operation = Operaciones.STANDBY
    }

    override fun limpiar() {
        this.operation = Operaciones.STANDBY
        this.firstValue = 0L
        this.secondValue = 0L
        this.result = 0F
    }
}