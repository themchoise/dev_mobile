package com.example.mjoyce.tp1.ej2_conversor

data class CurrencyResponse(
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)
