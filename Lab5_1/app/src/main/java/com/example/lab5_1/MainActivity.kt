package com.example.lab5_1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab5_1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    fun calculateBMI(height: Int, weight: Int): Float {
        val height_metre = height.toFloat() / 100
        val weight_metre = weight.toFloat()
        val BMI = weight_metre /(height_metre * height_metre)
        return BMI
    }



        binding.button.setOnClickListener {
            if (binding.etweight.text.isNotEmpty() && binding.etheight.text.isNotEmpty()) {
                val height = binding.etheight.text.toString().toInt()
                val weight = binding.etweight.text.toString().toInt()

                val BMI: Float = calculateBMI(height, weight)

                binding.bmi.text = BMI.toString()
                binding.bmi.visibility = View.VISIBLE

                if (BMI < 18.5) {
                    binding.resultIV.setImageResource(R.drawable.uw)
                } else if (BMI >= 18.5 && BMI < 24.9) {
                    binding.resultIV.setImageResource(R.drawable.n)
                } else if (BMI >= 24.9 && BMI < 30) {
                    binding.resultIV.setImageResource(R.drawable.ow)
                } else if (BMI >= 30 && BMI < 34.9) {
                    binding.resultIV.setImageResource(R.drawable.o)
                } else if (BMI >= 35) {
                    binding.resultIV.setImageResource(R.drawable.eo)
                }
                binding.resultIV.visibility = View.VISIBLE


            }

            else {
                Toast.makeText(this, "Podaj właściwą wagę oraz wzrost", Toast.LENGTH_SHORT).show()
            }
        }

    }


}




