package com.example.mathsgame.addition.level3

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.mathsgame.HomeActivity
import com.example.mathsgame.R
import com.example.mathsgame.sound.HappySoundService
import com.example.mathsgame.sound.bgSoundService
import kotlinx.android.synthetic.main.activity_congratulations1.*


class Congratulations3Activity : AppCompatActivity() {

//    private val numbers = mutableListOf("one", "two", "three", "four","five","six","seven","eight","nine")


    override fun onCreate(savedInstanceState: Bundle?) {
        stopService(Intent(this, bgSoundService::class.java))
        startService(Intent(this, HappySoundService::class.java))
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
            val intent1 = Intent(this, Addition3Activity::class.java)
//            intent.putExtra("qno3", quizNumber)
            intent.putExtra("qno4", false)

            startActivity(intent1)

        }

        back.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onPause() { //stop service and stop music
        stopService(Intent(this, HappySoundService::class.java))
        startService(Intent(this, bgSoundService::class.java))

        super.onPause()
    }
}
