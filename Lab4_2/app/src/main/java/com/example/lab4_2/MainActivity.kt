package com.example.lab4_2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab4_2.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val pieniadz = listOf(R.drawable.awers, R.drawable.rewers)
        val teksty = listOf("Reszka", "Orzeł")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener() {
            val index = Random.nextInt(0, pieniadz.size)
            val defaultRotation = binding.imageView2.rotationX
            Toast.makeText(this, "Rzucono monetą...", Toast.LENGTH_SHORT).show()

            binding.imageView2.setImageResource(pieniadz[index])
            }


        }

    }
