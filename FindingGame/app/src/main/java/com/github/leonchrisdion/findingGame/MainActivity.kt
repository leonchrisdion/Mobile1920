package com.github.leonchrisdion.findingGame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.leonchrisdion.findingGame.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val starOnResId = 17301516
    private val starOffResId = 17301515
    private lateinit var selectedView: View
    private var selectedId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val boxId: List<Int> = listOf(
            binding.boxOne.id,
            binding.boxTwo.id,
            binding.boxThree.id,
            binding.boxFour.id,
            binding.boxFive.id,
            binding.boxSix.id,
            binding.boxSeven.id,
            binding.boxEight.id
        )
        selectedId = boxId[Random.nextInt(0, 8)]
        Log.d("ActivityMain :: ", "SelectedID: ${selectedId}; From: ${boxId}")
        setListeners()
    }

    private fun setBehavior(view: View) {
        if(view.id == selectedId) {
            setButtonBackground(view, starOnResId)
            selectedView = view
            winHandler()
        } else setButtonBackground(view, starOffResId)
    }

    private fun setButtonBackground(view: View, buttonIcon: Int) {
        view.setBackgroundResource(buttonIcon)
    }

    private fun winHandler() {
        Toast.makeText(this, "YOU WIN! Tap the shining star to play again.", Toast.LENGTH_LONG).show()
        selectedView.setOnClickListener {
            resetAll()
        }
    }

    private fun resetAll() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val boxesId: List<Int> = listOf(
            binding.boxOne.id,
            binding.boxTwo.id,
            binding.boxThree.id,
            binding.boxFour.id,
            binding.boxFive.id,
            binding.boxSix.id,
            binding.boxSeven.id,
            binding.boxEight.id
        )
        selectedId = boxesId[Random.nextInt(0, 5)]
        Log.d("ActivityMain :: ", "SelectedID: ${selectedId}; From: ${boxesId}")

        binding.apply {
            val boxOne = boxOne
            val boxTwo= boxTwo
            val boxThree= boxThree
            val boxFour= boxFour
            val boxFive= boxFive
            val boxSix= boxSix
            val boxSeven= boxSeven
            val boxEight= boxEight

            val clickableViews: List<View> =
                listOf(boxOne, boxTwo, boxThree,
                    boxFour, boxFive, boxSix, boxSeven, boxEight)

            for (item in clickableViews) {
                item.setOnClickListener {
                    setBehavior(it)
                }
                item.setBackgroundColor(Color.WHITE)
            }
        }
    }

    private fun setListeners() {
        binding.apply {
            val boxOne = boxOne
            val boxTwo= boxTwo
            val boxThree= boxThree
            val boxFour= boxFour
            val boxFive= boxFive
            val boxSix= boxSix
            val boxSeven= boxSeven
            val boxEight= boxEight

            val clickableViews: List<View> =
                listOf(boxOne, boxTwo, boxThree,
                    boxFour, boxFive, boxSix, boxSeven, boxEight)

            for (item in clickableViews) {
                item.setOnClickListener {
                    setBehavior(it)
                }
            }
        }
    }
}
