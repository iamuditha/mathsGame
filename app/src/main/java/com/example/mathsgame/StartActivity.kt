package com.example.mathsgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.example.mathsgame.sound.bgSoundService
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        startService(Intent(this, bgSoundService::class.java))


        val anim : Animation =  AlphaAnimation(0.0f, 1.0f)
        anim.duration = 300 //You can manage the blinking time with this parameter
        anim.startOffset = 20
        anim.repeatMode = Animation.REVERSE
        anim.repeatCount = Animation.INFINITE
        start.startAnimation(anim)
        start.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}
