package com.example.plataformasalud_virtual

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)



        // Referencia al botón de acceder
        val accederButton: Button = findViewById(R.id.button) // Asegúrate de que el ID sea correcto
        accederButton.setOnClickListener {
            // Navegar a MenudeGestion
            val intent = Intent(this, MenudeGestion::class.java)
            startActivity(intent)
        }

        // Referencia al texto de registro
        val registro: TextView = findViewById(R.id.registro)
        registro.setOnClickListener {
            val intent = Intent(this, RegistrarseActivity::class.java)
            startActivity(intent)
        }

    }
}