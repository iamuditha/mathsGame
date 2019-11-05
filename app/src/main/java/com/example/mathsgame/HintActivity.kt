package com.example.mathsgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_hint.*

class HintActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hint)

        val intent = intent
        val bundle = intent.extras
        val correct_answer = bundle?.getInt("correct_answer")
        val input_answer = bundle?.getString("input_answer")?.toInt()


        if(correct_answer!! - input_answer!! == 1 || input_answer!! - correct_answer!! == 1){
            hint.text = "You Are So Close. Let's Try Again"
        }else if (input_answer%2 ==0 && correct_answer%2 != 0){
            hint.text = "Answer is an Odd Number. Let's Try Again"
        }else if (input_answer%2 !=0 && correct_answer%2 == 0){
            hint.text = "Answer is an Even Number. Let's Try Again"
        }else{
            hint.text = "Don't Worry. Lets Try Again"
        }

        AnotherQuiz.setOnClickListener {
            startActivity(Intent(this, AdditionActivity::class.java))
        }


    }
}
