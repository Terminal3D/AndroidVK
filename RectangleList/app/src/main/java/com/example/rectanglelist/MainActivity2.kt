package com.example.rectanglelist

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

const val NUM = "NUM_KEY"
const val COLOR = "COLOR_KEY"


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rectangleNumber = intent.getIntExtra(NUM, 0)
        val rectangleColor = intent.getIntExtra(COLOR, 0)

        val secondViewLayout: TextView = findViewById(R.id.second_activity_tv)
        secondViewLayout.setBackgroundResource(rectangleColor)
        secondViewLayout.text = rectangleNumber.toString()
    }


    companion object {
        fun newInstance(context: Context, num: Int, color: Int): Intent {
            return Intent(context, MainActivity2::class.java).apply {
                putExtra(NUM, num)
                putExtra(COLOR, color)
            }
        }
    }
}