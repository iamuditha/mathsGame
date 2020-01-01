package com.example.mathsgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_home.*
import com.example.mathsgame.addition.Addition1Activity
import com.example.mathsgame.addition.Addition2Activity
import com.example.mathsgame.addition.levelActivity


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        startAnimations()
        //click event on + button
        add.setOnClickListener {
            navigateToAddition()
        }
    }

    private fun startAnimations() {
        val buttonAnimation = AnimationUtils.loadAnimation(this,R.anim.from_right)
        add.startAnimation(buttonAnimation)
        substract.startAnimation(buttonAnimation)
        divide.startAnimation(buttonAnimation)
        mul.startAnimation(buttonAnimation)

    }

    //go to addition page
    private fun navigateToAddition() {
        val intent = Intent(this, levelActivity::class.java)
        startActivity(intent)
    }
}
