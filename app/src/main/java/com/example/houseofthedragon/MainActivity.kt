package com.example.houseofthedragon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enlace al botón e incorporación de evento "click".
        val btnAnswer = findViewById<Button>(R.id.btnAnswer)
        btnAnswer.setOnClickListener {
            val etNombre = findViewById<EditText>(R.id.etName)
            val nombre = etNombre.text.toString()

            if (nombre.isBlank()) {
                // Si no se ha introducido un nombre, muestra un mensaje.
                Toast.makeText(this, "Por favor, introduce un nombre", Toast.LENGTH_SHORT).show()
            } else {
                // Si se ha introducido un nombre, se pasa a la siguiente actividad
                goToElection(nombre)
            }
        }
    }

    private fun goToElection(nombre: String) {
        // Crear el intent y pasar el nombre.
        val intent = Intent(this, ElectionActivity::class.java)
        intent.putExtra("NAME", nombre)
        startActivity(intent)
    }
}
