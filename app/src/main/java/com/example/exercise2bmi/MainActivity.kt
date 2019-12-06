package com.example.exercise2bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var bmiImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bmiImage = findViewById(R.id.imageViewProfile)

        val calButton: Button = findViewById(R.id.buttonCalculate)
        calButton.setOnClickListener { bmiCalculator() }

        val resetButton: Button = findViewById(R.id.buttonReset)
        resetButton.setOnClickListener{reset()}
    }

    private fun bmiCalculator() {
        //edit
        val height: EditText = findViewById(R.id.editTextHeight)
        val weight: EditText = findViewById(R.id.editTextWeight)
        //output
        val viewbmi : TextView = findViewById(R.id.textViewBMI)
        //get
        val edit1 = height.text.toString().toDouble()
        val edit2 = weight.text.toString().toDouble()
        val meter: Double = edit1/100
        val result1: Double = edit2/(meter*meter)
        val result = String.format("%.1f",result1)
        viewbmi.setText("BMI :"+ String.format(result))
        //image
        if(result1 < 18.5){
            bmiImage.setImageResource(R.drawable.under)
        }else if(result1 > 24.9){
            bmiImage.setImageResource(R.drawable.over)
        }else if(result1>= 18.5 || result1 <= 24.9){
            bmiImage.setImageResource(R.drawable.normal)
        }

    }

    private fun reset() {
        val edit1: EditText = findViewById(R.id.editTextHeight)
        val edit2: EditText = findViewById(R.id.editTextWeight)
        val text1 : TextView = findViewById(R.id.textViewBMI)

        edit1.text.clear()
        edit2.text.clear()
        bmiImage.setImageResource(R.drawable.empty)
        text1.setText("BMI :")
    }

}
