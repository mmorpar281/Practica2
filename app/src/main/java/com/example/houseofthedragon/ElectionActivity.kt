package com.example.houseofthedragon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ElectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_election)

        val nombre = intent.getStringExtra("NAME")
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        tvGreeting.text = getString(R.string.greeting, nombre)

        val tvChoiceInfo = findViewById<TextView>(R.id.tvChoiceInfo)
        val checkboxRaenira = findViewById<CheckBox>(R.id.checkboxRaenira)
        val checkboxAegon = findViewById<CheckBox>(R.id.checkboxAegon)

        // Mostrar el mensaje de elección según las opciones seleccionadas
        val listener = CompoundButton.OnCheckedChangeListener { _, _ ->
            when {
                checkboxRaenira.isChecked && checkboxAegon.isChecked -> {
                    tvChoiceInfo.text = getString(R.string.both_selected)
                }
                checkboxRaenira.isChecked -> {
                    tvChoiceInfo.text = getString(R.string.raenira_selected)
                }
                checkboxAegon.isChecked -> {
                    tvChoiceInfo.text = getString(R.string.aegon_selected)
                }
                else -> {
                    tvChoiceInfo.text = getString(R.string.no_choice)
                }
            }
        }

        checkboxRaenira.setOnCheckedChangeListener(listener)
        checkboxAegon.setOnCheckedChangeListener(listener)

        // Acción del botón de "Hincar la rodilla"
        val btnKneel = findViewById<Button>(R.id.btnKneel)
        btnKneel.setOnClickListener {
            val selectedChoice = when {
                checkboxRaenira.isChecked && checkboxAegon.isChecked -> "ambos"
                checkboxRaenira.isChecked -> "Raenira"
                checkboxAegon.isChecked -> "Aegon"
                else -> "ninguno"
            }
            goToFinalActivity(selectedChoice)
        }
    }

    private fun goToFinalActivity(choice: String) {
        val intent = Intent(this, FinalActivity::class.java)
        intent.putExtra("CHOICE", choice)
        startActivity(intent)
    }
}