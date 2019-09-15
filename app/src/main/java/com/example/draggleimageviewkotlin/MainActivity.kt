package com.example.draggleimageviewkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var draggableImage: ImageView

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        draggableImage = findViewById(R.id.imageview);

        // hide action bar
        val actionBar = supportActionBar
        actionBar!!.hide()

        val listener = View.OnTouchListener(function = {view, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_MOVE) {

                view.y = motionEvent.rawY - view.height/2
                view.x = motionEvent.rawX - view.width/2
            }
            true
        })

        draggableImage.setOnTouchListener(listener)

    }
}
