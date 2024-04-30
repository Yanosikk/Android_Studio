package com.example.lab3_1

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab3_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val text = "Podano imię i nazwisko: ${binding.editTextText.text}"
            binding.textView.text = text
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            Log.d(MainActivity::class.toString(), text);
        }

    }
}