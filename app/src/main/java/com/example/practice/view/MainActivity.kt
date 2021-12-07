package com.example.practice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.practice.R
import com.example.practice.databinding.ActivityMainBinding
import com.example.practice.fragments.list.ListFragment


class MainActivity : AppCompatActivity(), OpenFragment {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbar()
        openFrag(ListFragment.newInstance())
    }

    private fun toolbar() = with(binding) {
        setSupportActionBar(mainToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        mainToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun openFrag(f: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragContainer, f)
            .commit()
    }

    companion object Constant {
        const val TITLE_KEY = "title"
    }
}