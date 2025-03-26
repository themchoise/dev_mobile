package com.example.mjoyce
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.ejercicios)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ejercicios)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnEnviar: Button = findViewById(R.id.btn_invertir)
        val btnQntCaracteres: Button = findViewById(R.id.btn_qnt_caracteres)
        val btnCambioColor: Button = findViewById(R.id.btn_cambio_color)


        val inputText: EditText = findViewById(R.id.input_text)
        val textResult: EditText = findViewById(R.id.text_result)


        val ejercicio = Ejercicio(this)
        ejercicio.invertirTexto(btnEnviar, inputText, textResult)
        ejercicio.qntCaracteres(btnQntCaracteres, inputText, textResult)
        ejercicio.cambioColor(btnCambioColor, inputText, textResult)


        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        }
    }
