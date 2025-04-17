package com.example.mjoyce.tp1.ej2_conversor

import android.os.Build
import androidx.annotation.RequiresApi
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.time.LocalDate


class ApiCurrency {


    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getCurrencyes(): CurrencyResponse {

        val url = URL("https://api.exchangerate-api.com/v4/latest/ARS")
        val connection = url.openConnection() as HttpURLConnection

        try {
            connection.requestMethod = "GET"
            connection.connectTimeout = 5000
            connection.readTimeout = 5000

            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val response = connection.inputStream.bufferedReader().use { it.readText() }
                return curRespToJson(response)
            } else {
                println("Error: $responseCode")
            }
        } finally {
            connection.disconnect()
        }
        return CurrencyResponse(
            base = "ARS",
            date = LocalDate.now().toString(),
            rates = mutableMapOf(
                "EUR" to 0.000749,
                "USD" to 0.000853,
                "BRL" to 0.00501
            )

        )
    }

    fun curRespToJson(json: String): CurrencyResponse {

        val jsonObject = JSONObject(json)
        val base = jsonObject.getString("base")
        val date = jsonObject.getString("date")
        val ratesJson = jsonObject.getJSONObject("rates")

        val rates = mutableMapOf<String, Double>()
        ratesJson.keys().forEach { key ->
            val value = ratesJson.getDouble(key)
            rates[key] = value
        }

        return CurrencyResponse(base, date, rates)

    }

}