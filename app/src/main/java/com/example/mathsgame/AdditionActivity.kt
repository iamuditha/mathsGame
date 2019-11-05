package com.example.mathsgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_addition.*
import net.objecthunter.exp4j.ExpressionBuilder

class AdditionActivity : AppCompatActivity() {

    private val numbers = mutableListOf("one", "two", "three", "four","five","six","seven","eight","nine")
    var quizNumber = 0

    private val additionRepo = AdditionRepositary()
    private val additionQuizList = additionRepo.fetchAdditionQuiz()

    private val myQuiz = additionQuizList[quizNumber].firstNum + additionQuizList[quizNumber].symbol + additionQuizList[quizNumber].secondNum

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addition)
//        showQuiz()
        displayNumbers()
        done.setOnClickListener {
            checkResult()
        }
    }

    private fun displayNumbers() {
        val index1 = additionQuizList[0].firstNum.toInt() - 1
        val index2 = additionQuizList[0].secondNum.toInt() - 1

        val resources = resources
        val resourceId1 = resources.getIdentifier(numbers[index1], "drawable", packageName)
        val resourceId2 = resources.getIdentifier(numbers[index2], "drawable", packageName)

        num1.setImageResource(resourceId1)
        num2.setImageResource(resourceId2)
    }

    private fun checkResult() {

        val expression = ExpressionBuilder(myQuiz).build()
        val correctResult = expression.evaluate()

        if (correctResult.toInt().toString() == answer.text.toString()){
            val intent = Intent(this, CongratulationsActivity::class.java)
            intent.putExtra("answer",(correctResult.toInt()-1).toString())
            intent.putExtra("qno",quizNumber)
            startActivity(intent)

        }else{
            startActivity(Intent(this, HintActivity::class.java))
        }

    }

//    private fun showQuiz(){
//        additionQuiz.text = myQuiz
//    }


}
