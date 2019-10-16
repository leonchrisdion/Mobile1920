package com.github.leonchrisdion.avengersEndgame


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.leonchrisdion.avengersEndgame.databinding.FragmentGameBinding
import com.github.leonchrisdion.avengersEndgame.MyApplication.Scene
import timber.log.Timber

class GameFragment : Fragment() {

    // Variables
    private val scenes = MyApplication.scenes
    lateinit var currentScene: Scene
    private var selectedActionId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate")
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false)

        // This is IMPORTANT! without this, "@{}" things in [fragment_game.sml] won't work.
        currentScene = scenes[0]

        // Bind this fragment class to the layout
        binding.scene = this

        // Listener for action button
        binding.actionButton.setOnClickListener {

            if(binding.actions.checkedRadioButtonId != -1) {

                when (binding.actions.checkedRadioButtonId) {
                    binding.actionOne.id -> selectedActionId = 0
                    binding.actionTwo.id -> selectedActionId = 1

                }

                when (currentScene) {
                    scenes[0] -> currentScene = scenes[1] // Intro
                    scenes[1] -> { // Unusual Encounter
                        when(selectedActionId) {
                            0 -> currentScene = scenes[10]
                            1 -> currentScene = scenes[2]
                        }
                    }
                    scenes[2] -> { // Kill Thanos
                        when(selectedActionId) {
                            0 -> currentScene = scenes[11]
                            1 -> currentScene = scenes[3]
                        }
                    }
                    scenes[3] -> { // Stones not retrieved
                        when(selectedActionId) {
                            0 -> currentScene = scenes[10]
                            1 -> currentScene = scenes[4]
                        }
                    }
                    scenes[4] -> { // Create time machine
                        when(selectedActionId) {
                            0 -> currentScene = scenes[5]
                            1 -> currentScene = scenes[10]
                        }
                    }
                    scenes[5] -> { // Time machine completed
                        when(selectedActionId) {
                            0 -> currentScene = scenes[6]
                            1 -> currentScene = scenes[10]
                        }
                    }
                    scenes[6] -> { // Retrieved the stones
                        when(selectedActionId) {
                            0 -> currentScene = scenes[11]
                            1 -> currentScene = scenes [8]
                        }
                    }
                    scenes[7] -> { // badEnding
                        MyApplication.badEnding = true
                        ending()
                    }
                    scenes[8] -> { //Thanos come
                        when(selectedActionId) {
                            0 -> currentScene = scenes[9]
                            1 -> currentScene = scenes[11]
                        }
                    }
                    scenes[9] -> { //Thanos get the stones
                        when(selectedActionId) {
                            0 -> currentScene = scenes[7]
                            1 -> currentScene = scenes[11]
                        }
                    }

                    scenes[10] -> { //normalEnding
                        MyApplication.normalEnding = true
                        ending()
                    }

                    scenes[11] -> {
                        MyApplication.bestEnding = true
                        ending()
                    }
                }

                // Disabling options if choice == "" and enabling them if not
                if (currentScene.actions[0] == "") binding.actionOne.isEnabled = false else binding.actionOne.isEnabled = true
                if (currentScene.actions[1] == "") binding.actionTwo.isEnabled = false else binding.actionTwo.isEnabled = true


                binding.actions.clearCheck()
                binding.scrollView.fullScroll(ScrollView.FOCUS_UP)
                binding.invalidateAll()
            } else {
                Toast.makeText(this.activity, "Select one of the actions to continue!", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    private fun ending() {

        when(selectedActionId) {
            0 -> this.activity!!.onBackPressed()
            1 -> currentScene = scenes[0]
        }
    }


    override fun onStart() {
        super.onStart()
        Timber.i("onStart called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop called")
    }

    override fun onDestroy()
    {
        super.onDestroy()
        Timber.i("onDestroy called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume called")
    }
}
