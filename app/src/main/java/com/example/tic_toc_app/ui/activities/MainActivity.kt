package com.example.tic_toc_app.ui.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.tic_toc_app.R
import com.example.tic_toc_app.ui.fragments.PlayerFragment
import com.example.tic_toc_app.ui.fragments.StartScreenFragment

class MainActivity : AppCompatActivity() {

    lateinit var fragment: Fragment

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragment = StartScreenFragment()
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_container, fragment)
        transaction.commit()

    }
}