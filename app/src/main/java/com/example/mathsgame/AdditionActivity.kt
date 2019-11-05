package com.example.mathsgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_addition.*
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.random.Random

class AdditionActivity : AppCompatActivity() {


    private val numbers = mutableListOf("one", "two", "three", "four","five","six","seven","eight","nine")
    private var quizNumber = Random.nextInt(3)

    private val additionRepo = AdditionRepositary()
    private val additionQuizList = additionRepo.fetchAdditionQuiz()




    override fun onCreate(savedInstanceState: Bundle?) {


         val top: Animation = AnimationUtils.loadAnimation(this,R.anim.from_top)
         val bottom: Animation = AnimationUtils.loadAnimation(this,R.anim.from_bottom)


        val myQuiz = additionQuizList[quizNumber].firstNum + additionQuizList[quizNumber].symbol + additionQuizList[quizNumber].secondNum
        Log.i("goo", myQuiz)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addition)
        displayNumbers()
        num1.startAnimation(top)
        num2.startAnimation(bottom)

        done.setOnClickListener {
            checkResult(myQuiz)
        }
    }


    private fun displayNumbers() {
        val index1 = additionQuizList[quizNumber].firstNum.toInt() - 1
        val index2 = additionQuizList[quizNumber].secondNum.toInt() - 1

        val resources = resources
        val resourceId1 = resources.getIdentifier(numbers[index1], "drawable", packageName)
        val resourceId2 = resources.getIdentifier(numbers[index2], "drawable", packageName)

        num1.setImageResource(resourceId1)
        num2.setImageResource(resourceId2)
    }

    private fun checkResult(Q : String) {

        val expression = ExpressionBuilder(Q).build()
        val correctResult = expression.evaluate()

        if (correctResult.toInt().toString() == answer.text.toString()){
            val intent = Intent(this, CongratulationsActivity::class.java)
            intent.putExtra("answer",(correctResult.toInt()-1).toString())
            intent.putExtra("qno2",quizNumber)
            startActivity(intent)

        }else{
            val intent3 = Intent(this, HintActivity::class.java)
            intent3.putExtra("correct_answer",(correctResult.toInt()))
            intent3.putExtra("input_answer",answer.text.toString())
            startActivity(intent3)
//            Log.i("answer", correctResult.toInt().toString())
//                     Log.i("answer", answer.text.toString())
        }

    }

}
