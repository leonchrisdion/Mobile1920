package com.github.leonchrisdion.avengersEndgame


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.leonchrisdion.avengersEndgame.databinding.FragmentEndingDisplayBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class EndingDisplay : Fragment() {

    val currentEnding: MyApplication.Scene = MyApplication.currentDisplayedEnding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEndingDisplayBinding>(inflater,
            R.layout.fragment_ending_display, container, false)

        binding.endingDisplay = this
        Timber.i("onCreate called")
        return binding.root
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
