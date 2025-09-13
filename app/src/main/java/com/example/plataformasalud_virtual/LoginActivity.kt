package com.example.plataformasalud_virtual

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Referencias a los campos
        val usuario = findViewById<EditText>(R.id.editTextText)
        val password = findViewById<EditText>(R.id.editTextTextPassword)
        val btnAcceder = findViewById<Button>(R.id.button)
        val registro = findViewById<TextView>(R.id.registro)

        // Acción al hacer clic en "Acceder"
        btnAcceder.setOnClickListener {
            val userText = usuario.text.toString().trim()
            val passText = password.text.toString().trim()

            when {
                userText.isEmpty() -> {
                    usuario.error = "El usuario es obligatorio"
                }
                passText.isEmpty() -> {
                    password.error = "La contraseña es obligatoria"
                }
                passText.length < 8 -> {
                    password.error = "La contraseña debe tener al menos 8 caracteres"
                }
                else -> {
                    Toast.makeText(this, "Validación correcta", Toast.LENGTH_SHORT).show()

                    // Si pasa la validación, navegar a MenudeGestion
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        // Acción al hacer clic en "Registrarse"
        registro.setOnClickListener {
            val intent = Intent(this, RegistrarseActivity::class.java)
            startActivity(intent)
        }
    }
}
