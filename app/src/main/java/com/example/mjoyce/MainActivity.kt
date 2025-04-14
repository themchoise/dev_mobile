package com.example.mjoyce
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mjoyce.tp0.MainTp
import com.example.mjoyce.tp1.CalculadoraView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val boton1=findViewById<Button>(R.id.btntp0)
        boton1.setOnClickListener {
            val intento1 = Intent(this, MainTp::class.java)
            startActivity(intento1)
        }

        findViewById<Button>(R.id.btntp2).setOnClickListener{
            startActivity(Intent(this, CalculadoraView::class.java))
        }




        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

        }
    }
