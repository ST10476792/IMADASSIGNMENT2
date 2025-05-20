package com.example.flashcardapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val reviewTextview = findViewById<TextView>(R.id.reviewTextview)
        val feedbackTextview = findViewById<TextView>(R.id.feedbackTextview)
        val reviewBtn = findViewById<Button>(R.id.reviewBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)

        val score = intent.getIntExtra("SCORE", 0)

        if (score >= 4 && score < 6) {
            //if the time of day is Morning,the textview will display Yoghurt and granola as a meal
            reviewTextview.text = "Great job. Well done! \uD83C\uDF89"
        } else if (score > 1  && score < 4) {
            //if the time of day is Mid morning,the textview will display Cream puffs as a snack
            reviewTextview.text = "Not bad! Keep trying\uD83D\uDCAA"
        } else {
            reviewTextview.text = " Time to hit the books\uD83D\uDCDA"
        }

        feedbackTextview.text = "You scored $score out of 5"


        reviewBtn.setOnClickListener {
                 reviewTextview.text = """
                1.  False.Jack the Ripper committed his murders in London, England, specifically in the Whitechapel district, during the late 1880s - most notably in 1888  
                
                2.  False.In reality, food distributors began making sacks more colorful and patterned to help people create more attractive clothing from them
                
                3.  True.His wives were Catherine Parr, Catherine Howard, Anne of Cleves, Jane Seymour, Anne Boleyn, and Catherine of Aragon
                
                4.  False. Juliana, a Great Dane, was indeed recognized for her bravery during World War II, but she was awarded the Blue Cross Medal, not the Medal of Honor (which is a U.S. military award given to humans).She extinguished an incendiary bomb by peeing on it!
                
                5.  True.She was actually Greek! 
            """.trimIndent()
        }

        exitBtn.setOnClickListener {
            finishAffinity()
        }
    }
}

