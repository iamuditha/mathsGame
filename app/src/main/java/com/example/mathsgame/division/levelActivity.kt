package com.example.mathsgame.division

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mathsgame.R
import com.example.mathsgame.division.level1.div1Activity
import com.example.mathsgame.division.level2.div2Activity
import com.example.mathsgame.division.level3.div3Activity
import com.example.mathsgame.multiplication.level1.level1.Mul1Activity
import com.example.mathsgame.multiplication.level1.level2.Mul2Activity
import com.example.mathsgame.multiplication.level1.level3.Mul3Activity
import com.example.mathsgame.substraction.substraction.level3.Sub3Activity
import kotlinx.android.synthetic.main.activity_level.*

class levelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        lvl1.setOnClickListener {
            startActivity(Intent(this, div1Activity::class.java))
        }

        lvl2.setOnClickListener {
            startActivity(Intent(this, div2Activity::class.java))
        }
        lvl3.setOnClickListener {
            startActivity(Intent(this, div3Activity::class.java))
        }
    }

}
