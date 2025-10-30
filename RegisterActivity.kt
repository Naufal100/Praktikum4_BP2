package com.example.a3129_myapplication1

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val radioGroupGender = findViewById<RadioGroup>(R.id.rg_gender)
        val checkBoxTerms = findViewById<CheckBox>(R.id.cb_terms)
        val spinnerDomisili = findViewById<Spinner>(R.id.spinner_domisili)
        val registerButton = findViewById<Button>(R.id.btn_submit_register)

        registerButton.setOnClickListener {
            val selectedGenderId = radioGroupGender.checkedRadioButtonId
            val gender = if (selectedGenderId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedGenderId)
                when (selectedRadioButton.id) {
                    R.id.rb_pria -> "Pria"
                    R.id.rb_wanita -> "Wanita"
                    else -> "Tidak diketahui"
                }
            } else {
                "Belum dipilih"
            }

            val isTermsChecked = checkBoxTerms.isChecked
            val domisili = spinnerDomisili.selectedItem.toString()

            val resultText = "Jenis Kelamin: $gender, Domisili: $domisili, Setuju: $isTermsChecked"
            Toast.makeText(this, resultText, Toast.LENGTH_LONG).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
