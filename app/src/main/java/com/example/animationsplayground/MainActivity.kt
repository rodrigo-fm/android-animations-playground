package com.example.animationsplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.transition.Transition
import android.transition.TransitionManager
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Group

class MainActivity : AppCompatActivity() {

    private lateinit var group: Group
    private lateinit var button: Button
    private lateinit var rootLayout: ConstraintLayout

    private fun createTransition(): Transition {
        val fade = Fade()
        fade.duration = 700L
        return fade
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.rootLayout)
        group = findViewById(R.id.activity_group)
        button = findViewById(R.id.myButton)

        button.setOnClickListener {
            TransitionManager.beginDelayedTransition(rootLayout, createTransition())
            button.visibility = View.GONE
            group.visibility = View.VISIBLE
        }

    }
}