package com.github.leonchrisdion.avengersEndgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.leonchrisdion.avengersEndgame.databinding.FragmentHowToPlayBinding
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class HowToPlay : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHowToPlayBinding>(inflater,
            R.layout.fragment_how_to_play, container, false)
        Timber.i("onCreate called")
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Timber.i("OnStart Called")
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