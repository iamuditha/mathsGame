package com.example.mathsgame.substraction.substraction.level1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.mathsgame.R
import kotlinx.android.synthetic.main.activity_try_again1.*
import net.objecthunter.exp4j.ExpressionBuilder

class TryAgain1Activity : AppCompatActivity() {

    private val numbers = mutableListOf("one", "two", "three", "four","five","six","seven","eight","nine")

    private val additionRepo =
        SubRepositary1()
    private val additionQuizList = additionRepo.fetchAdditionQuiz()




    override fun onCreate(savedInstanceState: Bundle?) {


        val top: Animation = AnimationUtils.loadAnimation(this,
            R.anim.from_top
        )
        val bottom: Animation = AnimationUtils.loadAnimation(this,
            R.anim.from_bottom
        )

        val intent = intent
        val bundle = intent.extras
        val quizNumber = bundle?.getInt("quizNo")
        Log.i("numm try", quizNumber.toString())


        val myQuiz = additionQuizList[quizNumber!!].firstNum + additionQuizList[quizNumber].symbol + additionQuizList[quizNumber].secondNum
//        Log.i("goo", myQuiz)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_try_again1)
        displayNumbers(quizNumber)
        num11.startAnimation(top)
        num21.startAnimation(top)
        additionSymbol1.startAnimation(bottom)
        answer1.startAnimation(bottom)
        done1.startAnimation(bottom)
        done1.setOnClickListener {
            checkResult(myQuiz,quizNumber)
        }
    }


    private fun displayNumbers(quizNo : Int) {
        val index1 = additionQuizList[quizNo].firstNum.toInt() - 1
        val index2 = additionQuizList[quizNo].secondNum.toInt() - 1

        val resources = resources
        val resourceId1 = resources.getIdentifier(numbers[index1], "drawable", packageName)
        val resourceId2 = resources.getIdentifier(numbers[index2], "drawable", packageName)

        num11.setImageResource(resourceId1)
        num21.setImageResource(resourceId2)
        additionSymbol1.setImageResource(R.drawable.substraction_symbol)
    }

    private fun checkResult(Q : String, quizNumber : Int) {

        val expression = ExpressionBuilder(Q).build()
        val correctResult = expression.evaluate()

        if (correctResult.toInt().toString() == answer1.text.toString()){
            val intent = Intent(this, Congratulations1Activity::class.java)
            intent.putExtra("answer",(correctResult.toInt()-1).toString())
           // intent.putExtra("qno2",quizNumber)
            startActivity(intent)

        }else{
            val intent3 = Intent(this, Hint1Activity::class.java)
            intent3.putExtra("correct_answer",(correctResult.toInt()))
            intent3.putExtra("input_answer",answer1.text.toString())
            intent3.putExtra("quizNo",quizNumber)
            startActivity(intent3)
//            Log.i("answer", correctResult.toInt().toString())
//                     Log.i("answer", answer.text.toString())
        }

    }

}
