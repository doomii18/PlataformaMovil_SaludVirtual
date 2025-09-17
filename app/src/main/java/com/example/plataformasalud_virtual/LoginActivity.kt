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
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Referencias a los layouts de usuario y contraseña
        val usuarioLayout = findViewById<TextInputLayout>(R.id.usuarioLayout)
        val passwordLayout = findViewById<TextInputLayout>(R.id.passwordLayout)

        // Referencias a los EditText
        val usuarioEdit = findViewById<TextInputEditText>(R.id.editTextUsuario)
        val passwordEdit = findViewById<TextInputEditText>(R.id.editTextPassword)

        // Botón de acceder
        val accederButton = findViewById<Button>(R.id.button)

        // Texto de registro
        val registro = findViewById<TextView>(R.id.registro)

        // Lista de usuarios válidos
        val usuariosValidos = mapOf(
            "admin" to "12345678",
            "doctor" to "medico2025",
            "paciente" to "salud1234"
        )

        // boton acceder
        accederButton.setOnClickListener{
            val userText = usuarioEdit.text.toString().trim()
            val passText = passwordEdit.text.toString().trim()

            //reiniciar errores
            usuarioLayout.error = null
            passwordLayout.error = null

            when {
                userText.isEmpty() -> {
                    usuarioLayout.error = "El usuario es obligatorio"
                }

                passText.isEmpty() -> {
                    passwordLayout.error = "La contraseña es obligatoria"
                }

                passText.length < 8 -> {
                    passwordLayout.error = "La contraseña debe tener al menos 8 caracteres"
                }

                else -> {
                    // Lista de usuarios válidos
                    val usuariosValidos = mapOf(
                        "admin" to "12345678",
                        "doctor" to "medico2025",
                        "paciente" to "salud1234"
                    )

                    // Validación
                    if (usuariosValidos[userText] == passText) {
                        Toast.makeText(this, "Bienvenido $userText", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MenuActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        usuarioLayout.error = "Usuario o contraseña incorrectos"
                        passwordLayout.error = "Usuario o contraseña incorrectos"
                    }
                }


            }
        }

        // txt regiatrarse
        registro.setOnClickListener {
            val intent = Intent(this, RegistrarseActivity::class.java)
            startActivity(intent)
        }
    }
}
