package com.example.tic_toc_app.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import com.example.tic_toc_app.R

class PickSideFragment : Fragment() {

    lateinit var playingFragment: PlayingFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pick_side, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val playerOne = arguments?.get("playerOne")
        Log.d("playerOne", "$playerOne")

        val playerTwo = arguments?.get("playerTwo")
        Log.d("playerTwo", "$playerTwo")

        val buttonContinue: Button = view.findViewById(R.id.buttonContinue)

        buttonContinue.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("playerOne", playerOne as String?)
            bundle.putString("playerTwo", playerTwo as String?)
            playingFragment = PlayingFragment()
            playingFragment.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_container, playingFragment)
                .addToBackStack(null)
                .commit()
        }
    }

}