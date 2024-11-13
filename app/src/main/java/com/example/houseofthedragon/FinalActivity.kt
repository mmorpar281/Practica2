package com.example.houseofthedragon

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val choice = intent.getStringExtra("CHOICE")
        val tvFinalMessage = findViewById<TextView>(R.id.tvFinalMessage)
        val btnExit = findViewById<Button>(R.id.btnExit)

        val message = when (choice) {
            "Raenira" -> getString(R.string.raenira_message)
            "Aegon" -> getString(R.string.aegon_message)
            "ambos" -> getString(R.string.both_message)
            else -> getString(R.string.no_choice_message)
        }

        tvFinalMessage.text = message

        btnExit.setOnClickListener {
            finishAffinity()  // Cierra la aplicación completamente
        }
    }
}
