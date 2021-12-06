package com.example.practice.view

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.practice.R
import com.example.practice.databinding.ActivityMainBinding
import com.example.practice.fragments.info.FragmentInfo
import com.example.practice.fragments.list.FragmentList


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbar()
        openFrag(FragmentList.newInstance())
    }

    private fun toolbar() = with(binding) {
        setSupportActionBar(mainToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        mainToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    fun openFrag(f: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragContainer, f)
            .commit()
    }

    companion object Constant{
        const val TITLE_KEY = "title"
        const val DATE_FORMAT = "dd.M.yyyy"
    }
}