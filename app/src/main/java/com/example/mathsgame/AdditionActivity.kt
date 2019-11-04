package com.example.mathsgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_addition.*
import net.objecthunter.exp4j.ExpressionBuilder

class AdditionActivity : AppCompatActivity() {

    private val additionRepo = AdditionRepositary()
    private val additionQuizList = additionRepo.fetchAdditionQuiz()
    private val myQuiz = additionQuizList[0].equation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addition)

        showQuiz()

        done.setOnClickListener {
            checkResult()
        }

    }

    private fun checkResult() {

        val expression = ExpressionBuilder(myQuiz).build()
        val correctResult = expression.evaluate()

        if (correctResult.toInt().toString() == answer.text.toString()){
            val intent = Intent(this, CongratulationsActivity::class.java)
            intent.putExtra("answer",(correctResult.toInt()-1).toString())
            startActivity(intent)

            Log.i("checking","done")
        }else{
            startActivity(Intent(this, HintActivity::class.java))
            Log.i("checking","worng")
        }

    }

    private fun showQuiz(){
        additionQuiz.text = myQuiz
    }


}
