package com.github.leonchrisdion.flipcoin

import android.os.Bundle
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var  flipButton: Button
    lateinit var viewImage: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flipButton= findViewById(R.id.flip)as Button
        viewImage= findViewById(R.id.coin) as ImageView
        flipButton.setOnClickListener{
            flipCoin()
        }
    }
    private fun flipCoin(){
        val side = Random().nextInt(2)
        if ( side == 0){
            viewImage.setImageResource(R.drawable.head)
            Toast.makeText(this, "HEAD", Toast.LENGTH_SHORT) . show()
        }
        else if ( side == 1){
            viewImage.setImageResource(R.drawable.tail)
            Toast.makeText(this, "TAIL", Toast.LENGTH_SHORT) . show()
        }


    }

}

