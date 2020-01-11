package com.example.mathsgame.addition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mathsgame.R
import com.example.mathsgame.addition.level1.Addition1Activity
import com.example.mathsgame.addition.level2.Addition2Activity
import com.example.mathsgame.addition.level3.Addition3Activity
import com.example.mathsgame.sound.bgSoundService
import kotlinx.android.synthetic.main.activity_level.*

class levelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)
        startService(Intent(this, bgSoundService::class.java))


        lvl1.setOnClickListener {
            startActivity(Intent(this, Addition1Activity::class.java))
        }

        lvl2.setOnClickListener {
            startActivity(Intent(this, Addition2Activity::class.java))
        }
        lvl3.setOnClickListener {
            startActivity(Intent(this, Addition3Activity::class.java))
        }
    }

}
