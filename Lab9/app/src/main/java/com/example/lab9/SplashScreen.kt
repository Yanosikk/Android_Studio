package com.example.lab9
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Timer
import kotlin.concurrent.timerTask

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        Timer().schedule(timerTask {
            val intent = Intent(this@SplashScreen, MainActivity:: class.java)
            startActivity(intent)
        }, 3000)
    }

    override fun onStop() {
        finish()
        super.onStop()
    }
    private fun logAndToast(event: String) {
        Log.d("MainActivity", event)
        Toast.makeText(this, "MainActivity: $event", Toast.LENGTH_SHORT).show()
    }
}

