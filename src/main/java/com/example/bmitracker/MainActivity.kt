package com.example.bmitracker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var height : EditText
    private lateinit var weight: EditText
    private lateinit var tvbm : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       val btncal = findViewById<Button>(R.id.cal)
        tvbm = findViewById(R.id.tvbmi)
        height = findViewById(R.id.editTextheight)
        weight = findViewById(R.id.editTextweight)
        btncal.setOnClickListener(){
            calculate()
        }

    }

    private fun calculate() {
        val heightStr = height.text.toString()
        val weightStr = weight.text.toString()

        if (heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
            val height = heightStr.toFloat()
            val weight = weightStr.toFloat()

            val bmi = weight / (height * height)

            val bmiResult = String.format("%.2f", bmi)

            tvbm.text = "Your BMI is: $bmiResult"
        } else {
            tvbm.text = "Please enter both height and weight"
        }

    }
}