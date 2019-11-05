package com.example.mathsgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_congratulations.*





class CongratulationsActivity : AppCompatActivity() {

    private val numbers = mutableListOf("one", "two", "three", "four","five","six","seven","eight","nine")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congratulations)

        val intent = intent
        val bundle = intent.extras
        val num = bundle?.getString("answer")
        val quizNumber = bundle?.getInt("qno")
        val number = numbers[num?.toInt()!!]

        val resources = resources
        val resourceId = resources.getIdentifier(
            number,
            "drawable", packageName
        )

        correctAnswer.setImageResource(resourceId)

        next.setOnClickListener {
            val intent1 = Intent(this, AdditionActivity::class.java)
            intent1.putExtra("qno1",quizNumber)
            startActivity(intent1)

        }
    }
}
