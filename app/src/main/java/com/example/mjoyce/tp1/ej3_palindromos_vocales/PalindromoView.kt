package com.example.mjoyce.tp1.ej3_palindromos_vocales


import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mjoyce.R


class PalindromoView : AppCompatActivity() {
    private lateinit var inputText: EditText
    private lateinit var resultText: TextView
    private lateinit var checkButton: Button
    private lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_palindromo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.palindromo)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputText = findViewById(R.id.inputText)
        resultText = findViewById(R.id.resultText)
        checkButton = findViewById(R.id.checkButton)
        layout = findViewById(R.id.palindromo)

        checkButton.setOnClickListener {
            val text = inputText.text.toString().lowercase()
            val isPalindrome = text == text.reversed()
            val vowels = "aeiouáéíóú"
            val vowelCount = text.count { it in vowels }

            resultText.text = "Vocales: $vowelCount"

            if (isPalindrome) {
                layout.setBackgroundColor(Color.parseColor("#A5D6A7"))
            } else {
                layout.setBackgroundColor(Color.WHITE)
            }
        }
    }
}
