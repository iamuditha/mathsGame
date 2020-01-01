package com.example.mathsgame.addition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mathsgame.R
import kotlinx.android.synthetic.main.activity_level.*

class levelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)

        lvl1.setOnClickListener {
            startActivity(Intent(this, Addition1Activity::class.java))
        }

        lvl2.setOnClickListener {
            startActivity(Intent(this, Addition2Activity::class.java))
        }
    }

}
