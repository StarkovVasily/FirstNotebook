package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice.Constant.TITLE_KEY
import com.example.practice.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbar()
        getTitleFromEdit()
    }

    private fun toolbar() = with(binding) {
        setSupportActionBar(mainToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        mainToolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun getTitleFromEdit() = with(binding) {
        mainTextView.text = intent.getStringExtra(TITLE_KEY)
    }
}