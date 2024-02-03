package com.example.tic_toc_app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.tic_toc_app.R

class StartScreenFragment : Fragment() {

    lateinit var playingFragment: PlayingFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_start_screen, container, false)
      //  val button_WithFriend : Button = view.findViewById(R.id.button_WithFriend)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonWithFriend : Button = view.findViewById(R.id.button_WithFriend)

        buttonWithFriend.setOnClickListener {

            playingFragment = PlayingFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_container, playingFragment)
                .addToBackStack(null)
                .commit()
        }

    }
}