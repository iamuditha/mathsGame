package com.example.mathsgame.substraction.substraction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mathsgame.R
import com.example.mathsgame.addition.level1.Addition1Activity
import com.example.mathsgame.addition.level2.Addition2Activity
import com.example.mathsgame.addition.level3.Addition3Activity
import com.example.mathsgame.substraction.substraction.level1.Sub1Activity
import com.example.mathsgame.substraction.substraction.level2.Sub2Activity
import com.example.mathsgame.substraction.substraction.level3.Sub3Activity
import kotlinx.android.synthetic.main.activity_level.*

class levelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        lvl1.setOnClickListener {
            startActivity(Intent(this, Sub1Activity::class.java))
        }

        lvl2.setOnClickListener {
            startActivity(Intent(this, Sub2Activity::class.java))
        }
        lvl3.setOnClickListener {
            startActivity(Intent(this, Sub3Activity::class.java))
        }
    }

}
