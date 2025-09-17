package com.example.plataformasalud_virtual

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistrarseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)

        //referencias a los layouts de usuario y contrase;as
        val usuarioLayout = findViewById<TextInputLayout>(R.id.tilUser)
        val emailLayout = findViewById<TextInputLayout>(R.id.tilEmail)
        val passwordLayout = findViewById<TextInputLayout>(R.id.tilPassword)
        val passwordLayout2 = findViewById<TextInputLayout>(R.id.tilPassword2)

        //referencias a los edittext
        val usuarioEdit = findViewById<TextInputEditText>(R.id.editTextUser)
        val emailEdit = findViewById<TextInputEditText>(R.id.editTextEmail)
        val passwordEdit = findViewById<TextInputEditText>(R.id.editTextPassword)
        val passwordEdit2 = findViewById<TextInputEditText>(R.id.editTextPassword2)

        //boton de registrarse
        val registrarseButton = findViewById<Button>(R.id.buttonRegister)

        //texto de inicio
        val inicioText = findViewById<TextView>(R.id.inicio)

        registrarseButton.setOnClickListener{
            val userText = usuarioEdit.text.toString().trim()
            val emailText = emailEdit.text.toString().trim()
            val passText = passwordEdit.text.toString().trim()
            val passText2 = passwordEdit2.text.toString().trim()

            //reiniciarse errores
            usuarioLayout.error = null
            emailLayout.error = null
            passwordLayout.error = null
            passwordLayout2.error = null

            when {
                userText.isEmpty() -> {
                    usuarioLayout.error = "El usuario es obligatorio"
                }

                emailText.isEmpty() -> {
                    emailLayout.error = "Ingrese un correo"
                }
                !Patterns.EMAIL_ADDRESS.matcher(emailText).matches() -> {
                    emailLayout.error = "Correo no válido"
                }

                passText.isEmpty() -> {
                    passwordLayout.error = "Ingrese una contraseña"
                }

                passText.length < 8 -> {
                    passwordLayout.error = "La contraseña debe tener al menos 8 caracteres"
                }

                passText2.isEmpty() -> {
                    passwordLayout2.error = "Confirme la contraseña"
                }
                passText != passText2 -> {
                    passwordLayout2.error = "Las contraseñas no coinciden"
                }
                else -> {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

                    //ir a la pantalla principal
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }

        }

        //ir al login
        inicioText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}