package com.example.rivetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.startup.AppInitializer
import app.rive.runtime.kotlin.RiveAnimationView
import app.rive.runtime.kotlin.RiveInitializer
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppInitializer.getInstance(applicationContext)
            .initializeComponent(RiveInitializer::class.java)
        setContentView(R.layout.activity_main)

        val ball = findViewById<RiveAnimationView>(R.id.ball)
        val slider = findViewById<Slider>(R.id.slider)
        val slider_txt = findViewById<TextView>(R.id.slider_txt)

        slider.addOnChangeListener{slider, value, fromUser->

            ball.setNumberState("State Machine 1", "open", value )

            slider_txt.text = value.toString()
        }


    }
}