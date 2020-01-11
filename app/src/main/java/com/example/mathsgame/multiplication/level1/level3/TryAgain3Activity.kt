package com.example.mathsgame.multiplication.level1.level3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.mathsgame.R
import com.example.mathsgame.addition.level3.Hint3Activity
import kotlinx.android.synthetic.main.activity_try_again3.*
import net.objecthunter.exp4j.ExpressionBuilder

class TryAgain3Activity : AppCompatActivity() {

    private val numbers = mutableListOf("one", "two", "three", "four","five","six","seven","eight","nine")

    private val additionRepo =
        MulRepositary3()
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


        val myQuiz = (additionQuizList[quizNumber!!].firstNum)+( additionQuizList[quizNumber].secondNum)+( additionQuizList[quizNumber].thirdNum) + additionQuizList[quizNumber].symbol + (additionQuizList[quizNumber].fourthNum)+(additionQuizList[quizNumber].fifthNum)+( additionQuizList[quizNumber].sixthNum)
        Log.i("goo", myQuiz)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_try_again3)
        displayNumbers(quizNumber)
        num5.startAnimation(top)
        num1.startAnimation(top)
        num2.startAnimation(top)
        num3.startAnimation(top)
        num4.startAnimation(top)
        num6a.startAnimation(top)
        additionSymbol.startAnimation(bottom)
        answer.startAnimation(bottom)
        done.startAnimation(bottom)
        done.setOnClickListener {
            checkResult(myQuiz,quizNumber)
        }
    }


    private fun displayNumbers(quizNo : Int) {
        val index1 = additionQuizList[quizNo].firstNum
        val index2 = additionQuizList[quizNo].secondNum

        val index3 = additionQuizList[quizNo].thirdNum
        val index4 = additionQuizList[quizNo].fourthNum
        val index5 = additionQuizList[quizNo].fifthNum
        val index6 = additionQuizList[quizNo].sixthNum

        Log.i("checkmee", index1.toString())
        Log.i("checkmee", (numbers[index1.toInt()-1]).toString())
        Log.i("checkmee", index3.toString())
        Log.i("checkmee", index4.toString())


        val resources = resources
        val resourceId1 = resources.getIdentifier(numbers[index1.toInt()-1], "drawable", packageName)
        val resourceId2 = resources.getIdentifier(numbers[index2.toInt()-1], "drawable", packageName)
        val resourceId3 = resources.getIdentifier(numbers[index3.toInt()-1], "drawable", packageName)
        val resourceId4 = resources.getIdentifier(numbers[index4.toInt()-1], "drawable", packageName)
        val resourceId5 = resources.getIdentifier(numbers[index5.toInt()-1], "drawable", packageName)
        val resourceId6 = resources.getIdentifier(numbers[index6.toInt()-1], "drawable", packageName)


        num1.setImageResource(resourceId2)
        num5.setImageResource(resourceId1)
        num2.setImageResource(resourceId3)
        num3.setImageResource(resourceId4)
        num4.setImageResource(resourceId5)
        num6a.setImageResource(resourceId6)
        additionSymbol.setImageResource(R.drawable.mul_symbol)

    }

    private fun checkResult(Q : String, quizNumber : Int) {

        val expression = ExpressionBuilder(Q).build()
        val correctResult = expression.evaluate()

        if (correctResult.toInt().toString() == answer.text.toString()){
            val intent = Intent(this, Congratulations3Activity::class.java)
            intent.putExtra("answer",(correctResult.toInt()-1).toString())
           // intent.putExtra("qno2",quizNumber)
            startActivity(intent)

        }else{
            val intent3 = Intent(this, com.example.mathsgame.multiplication.level1.level3.Hint3Activity::class.java)
            intent3.putExtra("correct_answer",(correctResult.toInt()))
            intent3.putExtra("input_answer",answer.text.toString())
            intent3.putExtra("quizNo",quizNumber)
            startActivity(intent3)
//            Log.i("answer", correctResult.toInt().toString())
//                     Log.i("answer", answer.text.toString())
        }

    }

}
