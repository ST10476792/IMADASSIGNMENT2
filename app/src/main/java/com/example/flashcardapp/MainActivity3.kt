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

        //pass the score between activities
        val score = intent.getIntExtra("SCORE", 0)

        if (score >= 4 && score < 6) {
            //if score is greater than or equal to 4 and smaller than 6,then displays a compliment with their score out of 5
            reviewTextview.text = "Great job. Well done! \uD83C\uDF89" + "You scored $score out of 5 \n "
        } else if (score > 1  && score < 4) {
            //if score is greater than 1 and smaller than 4,then displays a text to keep trying with their score out of 5
            reviewTextview.text = "Not bad! Keep trying\uD83D\uDCAA" + "You scored $score out of 5 \n"
        } else {
            //if score doesn't fit into those,then it is most likely 1 or below and they need to study more
            reviewTextview.text = " Time to hit the books\uD83D\uDCDA" + "You scored $score out of 5 \n"
        }

        //Title:Kotlin If...Else
        //Author: https://www.w3schools.com/
        //Date:26 May 2025
        //Version:1
        //Available:https://www.w3schools.com/kotlin/kotlin_conditions.php

        //Title:Conditional Expressions
        //Author:codecademy.com
        //Date:26 May 2025
        //Version:1
        //Available:https://www.codecademy.com/learn/learn-kotlin/modules/learn-kotlin-conditional-expressions/cheatsheet

        //when review button is clicked,the feedback textview will display the answers with explanations for all questions
        reviewBtn.setOnClickListener {
                 reviewTextview.text = """
                1.  False.Jack the Ripper committed his murders in London, England, specifically in the Whitechapel district, during the late 1880s - most notably in 1888  
                
                2.  False.In reality, food distributors began making sacks more colorful and patterned to help people create more attractive clothing from them
                
                3.  True.His wives were Catherine Parr, Catherine Howard, Anne of Cleves, Jane Seymour, Anne Boleyn, and Catherine of Aragon
                
                4.  False. Juliana, a Great Dane, was indeed recognized for her bravery during World War II, but she was awarded the Blue Cross Medal, not the Medal of Honor (which is a U.S. military award given to humans).She extinguished an incendiary bomb by peeing on it!
                
                5.  True.She was actually Greek! 
            """.trimIndent()
        }
        //pressing exit button will close the app
        exitBtn.setOnClickListener {
            finishAffinity()

            //Title:How can I close the whole Kotlin app when I click a button
            //Author:https://stackoverflow.com
            //Date:26 May 2025
            //Version:1
            //Available:https://stackoverflow.com/questions/52164887/how-can-i-close-the-whole-kotlin-app-when-i-click-a-button


        }
    }
}

