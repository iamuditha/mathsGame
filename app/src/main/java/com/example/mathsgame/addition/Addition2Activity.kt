package com.example.mathsgame.addition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.mathsgame.R
import kotlinx.android.synthetic.main.activity_addition1.additionSymbol
import kotlinx.android.synthetic.main.activity_addition1.answer
import kotlinx.android.synthetic.main.activity_addition1.done
import kotlinx.android.synthetic.main.activity_addition1.num2
import kotlinx.android.synthetic.main.activity_addition1.num4
import kotlinx.android.synthetic.main.activity_addition2.*
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.random.Random

class Addition2Activity : AppCompatActivity() {


    private val numbers = mutableListOf("one", "two", "three", "four","five","six","seven","eight","nine")
    private var quizNumber = Random.nextInt(4)



    private val additionRepo =
        AdditionRepositary2()
    private val additionQuizList = additionRepo.fetchAdditionQuiz()




    override fun onCreate(savedInstanceState: Bundle?) {


         val top: Animation = AnimationUtils.loadAnimation(this,
             R.anim.from_top
         )
         val bottom: Animation = AnimationUtils.loadAnimation(this,
             R.anim.from_bottom
         )

        val myQuiz = (additionQuizList[quizNumber].firstNum)+( additionQuizList[quizNumber].secondNum) + additionQuizList[quizNumber].symbol + (additionQuizList[quizNumber].thirdNum)+(additionQuizList[quizNumber].fourthNum)
        Log.i("goo", myQuiz)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addition2)
        displayNumbers()
        num1.startAnimation(top)
        num2.startAnimation(top)
        num3.startAnimation(top)
        num4.startAnimation(top)
        additionSymbol.startAnimation(bottom)
        answer.startAnimation(bottom)
        done.startAnimation(bottom)

        done.setOnClickListener {
            checkResult(myQuiz)
        }
    }


    private fun displayNumbers() {
        val index1 = additionQuizList[quizNumber].firstNum
        val index2 = additionQuizList[quizNumber].secondNum

        val index3 = additionQuizList[quizNumber].thirdNum
        val index4 = additionQuizList[quizNumber].fourthNum


        Log.i("checkmee", index1.toString())
        Log.i("checkmee", (numbers[index1.toInt()-1]).toString())
        Log.i("checkmee", index3.toString())
        Log.i("checkmee", index4.toString())


        val resources = resources
        val resourceId1 = resources.getIdentifier(numbers[index1.toInt()-1], "drawable", packageName)
        val resourceId2 = resources.getIdentifier(numbers[index2.toInt()-1], "drawable", packageName)
        val resourceId3 = resources.getIdentifier(numbers[index3.toInt()-1], "drawable", packageName)
        val resourceId4 = resources.getIdentifier(numbers[index4.toInt()-1], "drawable", packageName)


        num1.setImageResource(resourceId1)
        num2.setImageResource(resourceId2)
        num3.setImageResource(resourceId3)
        num4.setImageResource(resourceId4)
    }

    private fun checkResult(Q : String) {

        val expression = ExpressionBuilder(Q).build()
        val correctResult = expression.evaluate()
        Log.i("goo", correctResult.toString())

        if (correctResult.toInt().toString() == answer.text.toString()){
            val intent = Intent(this, Congratulations2Activity::class.java)
            intent.putExtra("answer",(correctResult.toInt()-1).toString())
            intent.putExtra("qno2",quizNumber)
            startActivity(intent)

        }else{
            val intent3 = Intent(this, Hint2Activity::class.java)
            intent3.putExtra("correct_answer",(correctResult.toInt()))
            intent3.putExtra("input_answer",answer.text.toString())
            intent3.putExtra("quizNo",quizNumber)
            startActivity(intent3)

        }

    }

}
