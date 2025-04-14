package com.example.mjoyce.tp1

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
        }
        this.result = 0F
    }

    override fun multiplicar() {
        this.result = (this.firstValue * this.secondValue).toFloat()
    }

    override fun procesar() {
        when (operation) {
            Operaciones.SUM -> this.sumar()
            Operaciones.RES -> this.restar()
            else -> println("")
        }
    }
}