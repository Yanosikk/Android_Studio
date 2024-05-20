package com.example.lab4_1

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab4_1.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    var activities = listOf("Piłka nożna", "Koszykówka", "Tenis ziemny", "Siatkówka", "Zbijak", "Pianino", "Gitara", "Skrzypce", "Gry komputerowe")
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val rand = activities.random()
            val text = "Wybrana czynność to: ${rand}!"
            Handler().postDelayed({
                binding.textView.text = text
            }, 4000 )
            Toast.makeText(this, "Kliknąłęś wybór czynności, poczekaj trwa losowanie: ", Toast.LENGTH_LONG).show()
            Handler().postDelayed({
                Toast.makeText(this, "Wybrano czynność: ${rand}", Toast.LENGTH_SHORT).show()
            }, 5000)

        }


    }

}