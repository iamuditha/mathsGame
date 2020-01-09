package com.example.mathsgame.substraction.substraction.level2

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.mathsgame.R
import com.example.mathsgame.SoundService
import kotlinx.android.synthetic.main.activity_congratulations1.*


class Congratulations2Activity : AppCompatActivity() {

//    private val numbers = mutableListOf("one", "two", "three", "four","five","six","seven","eight","nine")


    override fun onCreate(savedInstanceState: Bundle?) {
        startService(Intent(this, SoundService::class.java))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congratulations1)

        val bottom: Animation = AnimationUtils.loadAnimation(this,
            R.anim.from_bottom
        )

        congratulationImage.startAnimation(bottom)
        correct.startAnimation(bottom)
        next.startAnimation(bottom)


        val intent = intent
//        val bundle = intent.extras
//        val num = bundle?.getString("answer")
//        val quizNumber = bundle?.getInt("qno")!! +1
//        val number = numbers[num?.toInt()!!]
//
//        val resources = resources
//        val resourceId = resources.getIdentifier(
//            number,
//            "drawable", packageName
//        )
//
//        correctAnswer.setImageResource(resourceId)

        next.setOnClickListener {
            val intent1 = Intent(this, Sub2Activity::class.java)
//            intent.putExtra("qno3", quizNumber)
            intent.putExtra("qno4", false)

            startActivity(intent1)

        }
    }
    override fun onPause() { //stop service and stop music
        stopService(Intent(this, SoundService::class.java))
        super.onPause()
    }
}
