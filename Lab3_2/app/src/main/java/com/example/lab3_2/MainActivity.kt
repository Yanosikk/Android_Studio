package com.example.lab3_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab3_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Increment.setOnClickListener {
                count++;
                binding.tV.text = "Liczba wciśnięć przycisku ${count}"

        }
        binding.Decrement.setOnClickListener{
                count--;
                binding.tV.text = "Liczba wciśnięć przycisku ${count}"
        }
        binding.Reset.setOnClickListener{
                count = 0
                binding.tV.text = "Liczba wciśnięć przycisku ${count}"


        }
    }
}