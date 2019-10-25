package com.example.mathsgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //click event on + button
        add.setOnClickListener {
            navigateToAddition()
        }
    }

    //go to addition page
    private fun navigateToAddition() {
        val intent = Intent(this, AdditionActivity::class.java)
        startActivity(intent)
    }
}
