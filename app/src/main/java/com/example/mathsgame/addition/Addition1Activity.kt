package com.example.mathsgame.addition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.mathsgame.R
import kotlinx.android.synthetic.main.activity_addition1.*
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.random.Random

class Addition1Activity : AppCompatActivity() {


    private val numbers = mutableListOf("one", "two", "three", "four","five","six","seven","eight","nine")
    private var quizNumber = Random.nextInt(5)



    private val additionRepo =
        AdditionRepositary1()
    private val additionQuizList = additionRepo.fetchAdditionQuiz()




    override fun onCreate(savedInstanceState: Bundle?) {


         val top: Animation = AnimationUtils.loadAnimation(this,
             R.anim.from_top
         )
         val bottom: Animation = AnimationUtils.loadAnimation(this,
             R.anim.from_bottom
         )

        val myQuiz = additionQuizList[quizNumber].firstNum + additionQuizList[quizNumber].symbol + additionQuizList[quizNumber].secondNum
        Log.i("goo", myQuiz)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addition1)
        displayNumbers()
        num2.startAnimation(top)
        num4.startAnimation(top)
        additionSymbol.startAnimation(bottom)
        answer.startAnimation(bottom)
        done.startAnimation(bottom)

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

        num2.setImageResource(resourceId1)
        num4.setImageResource(resourceId2)
    }

    private fun checkResult(Q : String) {

        val expression = ExpressionBuilder(Q).build()
        val correctResult = expression.evaluate()

        if (correctResult.toInt().toString() == answer.text.toString()){
            val intent = Intent(this, Congratulations1Activity::class.java)
            intent.putExtra("answer",(correctResult.toInt()-1).toString())
            intent.putExtra("qno2",quizNumber)
            startActivity(intent)

        }else{
            val intent3 = Intent(this, Hint1Activity::class.java)
            intent3.putExtra("correct_answer",(correctResult.toInt()))
            intent3.putExtra("input_answer",answer.text.toString())
            intent3.putExtra("quizNo",quizNumber)
            startActivity(intent3)

        }

    }

}
