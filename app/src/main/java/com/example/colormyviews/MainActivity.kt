package com.example.colormyviews

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Constraint_layout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setListeners()
    }

    private fun setListeners() {
        val clickableViews : List<View> =
            listOf(
                findViewById(R.id.box_one_text) , findViewById(R.id.box_two_text) ,
                findViewById(R.id.box_three_text) , findViewById(R.id.box_four_text) ,
                findViewById(R.id.box_five_text) , findViewById(R.id.Constraint_layout) ,
                findViewById(R.id.red_button) , findViewById(R.id.green_button) , findViewById(R.id.yellow_button)
            )

        for (item in clickableViews){
            item.setOnClickListener{ makeColored(it)}
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun makeColored(view: View) {
        when(view.id){
            R.id.box_one_text -> view.setBackgroundColor(Color.RED)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_orange_light)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_blue_bright)

            R.id.red_button -> findViewById<View>(R.id.box_two_text).setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> findViewById<View>(R.id.box_one_text).setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> findViewById<View>(R.id.box_four_text).setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)

        }

    }
}