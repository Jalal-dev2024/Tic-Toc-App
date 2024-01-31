package com.example.tic_toc_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_WithAI = findViewById<Button>(R.id.button_WithAI)
        val button_WithFriend = findViewById<Button>(R.id.button_WithFriend)

        button_WithAI.setOnClickListener {
            val intent = Intent(this, PlayerSecondActivity::class.java)
            startActivity(intent)
        }

        button_WithFriend.setOnClickListener {
            val intent = Intent(this, PlayerSecondActivity::class.java)
            startActivity(intent)
        }
    }
}