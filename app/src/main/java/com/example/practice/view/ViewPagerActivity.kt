package com.example.practice.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.practice.R
import com.example.practice.databinding.ActivityViewPagerBinding
import com.example.practice.model.NoteDatabase
import com.example.practice.presenter.*
import com.example.practice.viewPager.ViewPagerAdapter

class ViewPagerActivity : AppCompatActivity(), ViewPagerView {

    private lateinit var binding: ActivityViewPagerBinding
    private lateinit var presenter: VPagerPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = VPagerPresenterImpl(this, NoteDatabase.getInstance(this))
        initViewPager()
        toolbarAction()
    }

    private fun initViewPager() {
        binding.viewPager.adapter = ViewPagerAdapter(presenter.noteData())
    }

    private fun toolbarAction() = with(binding) {
        saveBtn.setOnClickListener {
            presenter.saveFromPager()
        }
        backBtnPager.setOnClickListener {
            onBackPressed()
        }
    }

    override fun showMessage() {
        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show()
    }
}