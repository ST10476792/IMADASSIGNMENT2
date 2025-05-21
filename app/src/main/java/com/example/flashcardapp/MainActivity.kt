package com.example.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startButton)
        val flashcardText1 = findViewById<TextView>(R.id.flashcardText1)
        val flashcardText2 = findViewById<TextView>(R.id.flashcardText2)

        //when button is pressed,it navigates from first screen to second screen
        startButton.setOnClickListener()
        {
            val intent = Intent(this, MainActivity2::class.java)

            startActivity(intent)

            //Title:How to navigate from one screen to another screen
            //Author:https://stackoverflow.com/
            //Date:21 May 2025
            //Version:1
            //Available:https://stackoverflow.com/questions/1102050/how-to-navigate-from-one-screen-to-another-screen

        }
    }
}
