package com.example.peliculasapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.peliculasapp.R
import com.example.peliculasapp.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        editTextUsername = findViewById(R.id.editTextUsername) as EditText
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            // Aquí puedes agregar la lógica para verificar las credenciales
            // por ejemplo, puedes compararlas con valores predefinidos o consultar
            // una base de datos remota.
            if (username == "Admin" && password == "Password*123") {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                // Credenciales correctas, iniciar sesión
                // Puedes iniciar otra actividad o realizar cualquier acción aquí
            } else {
                Toast.makeText(this,"Las credenciales son incorrectas", Toast.LENGTH_LONG).show()
                // Credenciales incorrectas, mostrar un mensaje de error
                // o realizar cualquier acción apropiada.
            }
        }
    }
}