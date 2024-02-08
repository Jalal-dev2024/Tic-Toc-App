package com.example.tic_toc_app.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import com.example.tic_toc_app.R

class PlayingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvPlayerName1: TextView = view.findViewById(R.id.tvPlayerName1)
        val tvPlayerName2: TextView = view.findViewById(R.id.tvPlayerName2)

        val playerOne = arguments?.get("playerOne")
        tvPlayerName1.text = playerOne.toString()
        //        Log.d("playerOne", "$playerOne")
        val playerTwo = arguments?.get("playerTwo")
        tvPlayerName2.text = playerTwo.toString()
    }

}