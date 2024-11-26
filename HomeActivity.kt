
package com.example.clutterfreeapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnStartDecluttering: Button = findViewById(R.id.btnStartDecluttering)
        btnStartDecluttering.setOnClickListener {
            val intent = Intent(this, DeclutteringActivity::class.java)
            startActivity(intent)
        }
    }
}
