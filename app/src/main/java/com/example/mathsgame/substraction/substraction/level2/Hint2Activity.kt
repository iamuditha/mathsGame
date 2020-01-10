package com.example.mathsgame.substraction.substraction.level2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.mathsgame.R
import com.example.mathsgame.SadSoundService
import kotlinx.android.synthetic.main.activity_hint.*

class Hint2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        startService(Intent(this, SadSoundService::class.java))

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hint)

        val top: Animation = AnimationUtils.loadAnimation(this,
            R.anim.from_top
        )
        val bottom: Animation = AnimationUtils.loadAnimation(this,
            R.anim.from_bottom
        )

        AnotherQuiz.startAnimation(bottom)
        tryAgain.startAnimation(bottom)
        showAnswer.startAnimation(bottom)
        hint.startAnimation(top)

        val intent = intent
        val bundle = intent.extras
        val correct_answer = bundle?.getInt("correct_answer")
        val input_answer = bundle?.getString("input_answer")?.toInt()
        val num = bundle?.getInt("quizNo")
        val quizNumber = num
        Log.i("numm hint", quizNumber.toString())


        if(correct_answer!! - input_answer!! == 1 || input_answer!! - correct_answer!! == 1){
            hint.text = "You Are So Close. Let's Try Again."
        }else if (input_answer%2 ==0 && correct_answer%2 != 0){
            hint.text = "Answer is an Odd Number. Let's Try Again."
        }else if (input_answer%2 !=0 && correct_answer%2 == 0){
            hint.text = "Answer is an Even Number. Let's Try Again."
        }else{
            hint.text = "Don't Worry. Let's Try Again."
        }

        AnotherQuiz.setOnClickListener {
            startActivity(Intent(this, Sub2Activity::class.java))
        }

        tryAgain.setOnClickListener {
            val intent4 = Intent(this, TryAgain2Activity::class.java)
            intent4.putExtra("quizNo",quizNumber)
            startActivity(intent4)
        }

        showAnswer.setOnClickListener {
            hint.visibility = View.INVISIBLE
            answer.visibility = View.VISIBLE
            answer.text = correct_answer.toString()
        }


    }
}
