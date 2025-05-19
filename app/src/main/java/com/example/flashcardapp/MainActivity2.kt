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
    private val questions = arrayOf(
        "Jack the Ripper's crimes took place in New York City during the early 1900s",
        "During the Great Depression, people made clothes out of food sacks like flour bags and potato sacks, and food distributors responded by switching to plain, unprinted sacks to discourage the trend \n ",
        "Henry VIII had six wives \n",
        "During World War II, a Great Dane named Juliana was awarded the Medal of Honor for her service \n",
        "Cleopatra wasn’t actually Egyptian \n"
    )

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

        val answers = arrayOf(false, false, true, false, true)
        var currentQuestionIndex = 0
        var score = 0

        fun goToResultScreen() {
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("SCORE", score)
            intent.putExtra("QUESTIONS", questions)
            intent.putExtra("ANSWERS", answers)
            startActivity(intent)
        }
    // intent put extra add code to push to next screen

        fun loadNextQuestion() {
            if (currentQuestionIndex < questions.size) {
                questionTextView.text = questions[currentQuestionIndex]
            } else {
                goToResultScreen()
            }
    }
    // question.size is no. of question in array

        fun checkAnswer(userAnswer: Boolean) {
            if (userAnswer == answers[currentQuestionIndex]) {
                answerTextview.text = "Correct"
                score++
            } else {
                answerTextview.text = "Incorrect"
            }
            currentQuestionIndex++
            loadNextQuestion()
            //moving on to next question
        }

        trueBtn.setOnClickListener { checkAnswer(true) }
        falseBtn.setOnClickListener { checkAnswer(false) }








        }


    }
    }
