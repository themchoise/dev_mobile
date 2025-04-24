package com.example.mjoyce.tp1.ej_4_numero


import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mjoyce.R
import kotlin.math.abs
import kotlin.random.Random

class NumeroView : AppCompatActivity() {

    private lateinit var guessInput: EditText
    private lateinit var feedbackText: TextView
    private lateinit var attemptsText: TextView
    private lateinit var scoreText: TextView
    private lateinit var checkButton: Button

    private var secretNumber = 0
    private var attempts = 5
    private var score = 5 // Empieza con 5 puntos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_numero)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.numero)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        guessInput = findViewById(R.id.guessInput)
        feedbackText = findViewById(R.id.feedbackText)
        attemptsText = findViewById(R.id.attemptsText)
        scoreText = findViewById(R.id.scoreText)
        checkButton = findViewById(R.id.checkGuess)

        initGame()

        checkButton.setOnClickListener {
            if (attempts > 0 && score > 0) {
                val guess = guessInput.text.toString().toIntOrNull()
                if (guess == null) {
                    feedbackText.text = "Ingrese un número válido"
                    return@setOnClickListener
                }

                val diff = abs(secretNumber - guess)

                val feedback = when {
                    guess == secretNumber -> {
                        score++
                        initGame()
                        "¡Correcto! Nuevo número generado."
                    }

                    diff > 50 -> "Muy lejos"
                    diff in 21..50 -> "Lejos"
                    diff in 6..20 -> "Cerca"
                    else -> "Muy cerca"
                }

                if (guess != secretNumber) {
                    attempts--
                    if (attempts == 0) {
                        score = (score - 1).coerceAtLeast(0)
                        if (score == 0) {
                            feedbackText.text = "¡Fin del juego! Intenta de nuevo."
                            checkButton.isEnabled = false
                        } else {
                            feedbackText.text = "Sin intentos. Nuevo número generado."
                            initGame()
                        }
                    } else {
                        feedbackText.text = feedback
                    }
                }

                updateUI()
            }
        }
    }

    private fun initGame() {
        secretNumber = Random.nextInt(1, 101)
        attempts = 5
        updateUI()
    }

    private fun updateUI() {
        attemptsText.text = "Chances restantes: $attempts"
        scoreText.text = "Puntaje: $score"
        guessInput.setText("")
    }
}
