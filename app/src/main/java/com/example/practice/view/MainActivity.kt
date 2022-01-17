package com.example.practice.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.practice.R
import com.example.practice.databinding.ActivityMainBinding
import com.example.practice.fragments.info.Dialog
import com.example.practice.fragments.info.InfoFragment
import com.example.practice.fragments.list.ListFragment


class MainActivity : AppCompatActivity(), MainView.Fragments, MainView.View, Save {
    private lateinit var binding: ActivityMainBinding

    override var currentFragment: InfoFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbar()
        openFrag(ListFragment.newInstance(), false)
    }

    private fun toolbar() = with(binding) {
        backBtnMain.setOnClickListener {
            onBackPressed()
        }
        goToAbout.setOnClickListener {
            startActivity(Intent(this@MainActivity, AboutActivity::class.java))
        }
        saveBtnMain.setOnClickListener {
            Dialog().show(
                supportFragmentManager,
                CREATE
            )
        }
        shareBtnMain.setOnClickListener {
            currentFragment?.share()
        }
    }

    override fun save() {
        currentFragment?.save()
    }

    override fun openFrag(f: Fragment, toStack: Boolean) {
        if (toStack) {
            supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragContainer, f)
                .commit()
        } else {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragContainer, f)
                .commit()
        }
    }

    override fun showSaveShare() {
        binding.apply {
            shareBtnMain.isVisible = true
            saveBtnMain.isVisible = true
            goToAbout.isVisible = false
        }
    }

    override fun hideSaveShare() {
        binding.apply {
            shareBtnMain.isVisible = false
            saveBtnMain.isVisible = false
            goToAbout.isVisible = true
        }
    }

    companion object Constant {
        const val TITLE_KEY = "title"
        const val CREATE = "createNote"
    }
}