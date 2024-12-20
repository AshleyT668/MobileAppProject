package com.example.clutterfreeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonHome = findViewById<Button>(R.id.buttonHome)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val buttonBooking = findViewById<Button>(R.id.buttonBooking)

        buttonHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        buttonLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        buttonBooking.setOnClickListener {
            startActivity(Intent(this, BookingActivity::class.java))
        }
    }
}
