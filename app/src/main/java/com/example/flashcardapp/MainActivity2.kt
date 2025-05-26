package com.example.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    //questions in array
    private val questions = arrayOf(
        "Jack the Ripper's crimes took place in New York City during the early 1900s \n ",
        "During the Great Depression, people made clothes out of food sacks like flour bags and potato sacks, and food distributors responded by switching to plain, unprinted sacks to discourage the trend \n ",
        "Henry VIII had six wives \n",
        "During World War II, a Great Dane named Juliana was awarded the Medal of Honor for her service \n",
        "Cleopatra wasn’t actually Egyptian \n"
    )
    //question answers in array
    val answers = arrayOf(false, false, true, false, true)

    //Title:Arrays
    //Author: https://kotlinlang.org/
    //Date:21 May 2025
    //Version:1
    //Available:https://kotlinlang.org/docs/arrays.html

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val headingTextview = findViewById<TextView>(R.id.headingTextview)
        val questionTextView = findViewById<TextView>(R.id.questionTextview)
        val answerTextview = findViewById<TextView>(R.id.answerTextview)
        val trueBtn = findViewById<Button>(R.id.trueBtn)
        val falseBtn = findViewById<Button>(R.id.falseBtn)
        val nextBtn = findViewById<Button>(R.id.nextBtn)

        //index is 0 so it starts from first question
        var index = 0
        var score = 0

        //navigates from second screen to third screen
        fun goToScoreScreen() {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }


        //loads next question and clears the textview which displays if its incorrect/correct
        fun loadNextQuestion() {
            questionTextView.text = questions[index]
            answerTextview.text = ""
        }

        //checks whether chosen answer matches the answer array
        fun checkAnswer(userAnswer: Boolean) {
            val correct = answers[index]
            if (userAnswer == correct) {
                answerTextview.text = "Correct!"
                score++
            } else {
                answerTextview.text = "Incorrect!"
            }
        }
        //Title:Check incoming answer with answer in array object
        //Author: https://stackoverflow.com/
        //Date:21 May 2025
        //Version:1
        //Available:https://stackoverflow.com/questions/65619688/check-incoming-answer-with-answer-in-array-object


        //when true/false button is clicked,checks whether answer matches
        trueBtn.setOnClickListener { checkAnswer(true) }
        falseBtn.setOnClickListener { checkAnswer(false) }

        //when next button is clicked,proceeds to next question...if last question reached then it navigates to the third screen which is the score screen
        nextBtn.setOnClickListener {
            index++
            if (index < questions.size) {
                loadNextQuestion()
            } else {
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("SCORE", score)
                startActivity(intent)
                finish()
                // intent put extra adds code to push to next screen

            }
        }
        loadNextQuestion()
    }
}

