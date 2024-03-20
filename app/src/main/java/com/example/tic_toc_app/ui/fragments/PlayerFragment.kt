package com.example.tic_toc_app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import com.example.tic_toc_app.R

class PlayerFragment : Fragment() {

    lateinit var pickSideFragment: PickSideFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonNext: Button = view.findViewById(R.id.buttonNext)
        val etNickNameOne: EditText = view.findViewById(R.id.etNickNameOne)
        val etNickNameTwo: EditText = view.findViewById(R.id.etNickNameTwo)

        buttonNext.setOnClickListener {

            val nameOne = etNickNameOne.text.toString()
            val nameTwo = etNickNameTwo.text.toString()

            if (nameOne.isEmpty()) {
                Toast.makeText(context, "Player One Please Enter Your Name!", Toast.LENGTH_LONG).show()
            } else if (nameTwo.isEmpty()) {
                Toast.makeText(context, "Player Two Please Enter Your Name!", Toast.LENGTH_LONG).show()
            } else {

                val bundle = Bundle()
                bundle.putString("playerOne", nameOne)
                bundle.putString("playerTwo", nameTwo)
                pickSideFragment = PickSideFragment()
                pickSideFragment.arguments = bundle
                parentFragmentManager.beginTransaction()
                    .replace(R.id.main_container, pickSideFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }

    }
}